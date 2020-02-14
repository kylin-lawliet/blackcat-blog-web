package com.blackcat.blog.common.shiro.credentials;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blackcat.blog.common.holder.RequestHolder;
import com.blackcat.blog.core.entity.SysUser;
import com.blackcat.blog.core.service.SysUserService;
import com.blackcat.blog.util.IpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * <p> 描述 : Shiro-密码输入错误的状态下重试次数的匹配管理
 * @author : blackcat
 * @date  : 2020/2/14 11:26
*/
public class RetryLimitCredentialsMatcher extends CredentialsMatcher {

    public static final String USER_SESSION_KEY = "user";

    /**
     * 用户登录次数计数  redisKey 前缀
     */
    private static final String SHIRO_LOGIN_COUNT = "shiro_login_count_";
    /**
     * 用户登录是否被锁定    一小时 redisKey 前缀
     */
    private static final String SHIRO_IS_LOCK = "shiro_is_lock_";
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SysUserService userService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        SysUser shiroUser = (SysUser) info.getPrincipals().getPrimaryPrincipal();
        SysUser user = userService.getOne(new QueryWrapper<SysUser>().eq("id",shiroUser.getId()));
        String username = user.getUsername();
        // 访问一次，计数一次
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String loginCountKey = SHIRO_LOGIN_COUNT + username;
        String isLockKey = SHIRO_IS_LOCK + username;
        opsForValue.increment(loginCountKey, 1);

        if (redisTemplate.hasKey(isLockKey)) {
            throw new ExcessiveAttemptsException("帐号[" + username + "]已被禁止登录！");
        }

        // 计数大于5时，设置用户被锁定一小时
        String loginCount = String.valueOf(opsForValue.get(loginCountKey));
        int retryCount = (5 - Integer.parseInt(loginCount));
        if (retryCount <= 0) {
            opsForValue.set(isLockKey, "LOCK");
            redisTemplate.expire(isLockKey, 1, TimeUnit.HOURS);
            redisTemplate.expire(loginCountKey, 1, TimeUnit.HOURS);
            throw new ExcessiveAttemptsException("由于密码输入错误次数过多，帐号[" + username + "]已被禁止登录！");
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (!matches) {
            String msg = retryCount <= 0 ? "您的账号一小时内禁止登录！" : "您还剩" + retryCount + "次重试的机会";
            throw new AccountException("帐号或密码不正确！" + msg);
        }

        //清空登录计数
        redisTemplate.delete(loginCountKey);
        try {
            SysUser sysUser= new SysUser();
            sysUser.setLastLoginIp(IpUtil.getRealIp(RequestHolder.getRequest()));
            sysUser.setLastLoginTime(LocalDateTime.now());
            sysUser.setLoginCount(user.getLoginCount() + 1);
            userService.update(user, new UpdateWrapper<SysUser>().eq("id", user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 当验证都通过后，把用户信息放在session里
        // 注：User必须实现序列化
        SecurityUtils.getSubject().getSession().setAttribute(USER_SESSION_KEY, user);
        return true;
    }
}
