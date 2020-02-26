package com.blackcat.blog.common.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * <p> 描述 ：解决successUrl没生效问题
 * @author : blackcat
 * @date : 2020/2/20 20:25
 */
@Component
@WebFilter(urlPatterns = "/*" , filterName = "authenticationFilter")
public class Authentication extends FormAuthenticationFilter{

    /**
     * 网上解决方法其中之一
     *
     * 因为发现设置的successUrl没生效，所以追踪源码发现如果SavedRequest对象不为null,则它会覆盖掉我们设置
     * 的successUrl，所以我们要重写onLoginSuccess方法，在它覆盖掉我们设置的successUrl之前，去除掉
     * SavedRequest对象,SavedRequest对象的获取方式为：
     * savedRequest = (SavedRequest) session.getAttribute(SAVED_REQUEST_KEY);
     * public static final String SAVED_REQUEST_KEY = "shiroSavedRequest";
     * 解决方案：从session对象中移出shiroSavedRequest
     */
    /*@Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
       ServletRequest request, ServletResponse response) throws Exception {
        if (!StringUtils.isEmpty(getSuccessUrl())) {
            // getSession(false)：如果当前session为null,则返回null,而不是创建一个新的session
            Session session = subject.getSession(false);
            if (session != null) {
                session.removeAttribute("shiroSavedRequest");
            }
        }
        return super.onLoginSuccess(token, subject, request, response);
    }*/

    /**
     * 该方法及以下方法其中之一
    */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/admin";
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.issueRedirect(request,response,successUrl);
        return false;
    }

    /**
     * SpringBoot 提供了 FilterRegistrationBean 方便我们对 Filter 进行管理。 将不需要注册的 Filter 注入方法。 不然会报错
     */
    @Bean
    public FilterRegistrationBean registration (AuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
