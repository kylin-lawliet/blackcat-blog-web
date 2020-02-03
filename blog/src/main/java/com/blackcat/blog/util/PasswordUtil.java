package com.blackcat.blog.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * <p> ：密码加密解密
 * @author : blackcat
 * @date : 2020/1/18 14:41
 */
public class PasswordUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    /**
     * 安全密码(UUID生成)，作为盐值用于用户密码的加密
     */
    public static final String ZYD_SECURITY_KEY = "929123f8f17944e8b0a531045453e1f1";


    /**
     * AES 加密
     * @param password 未加密的密码
     * @param salt 盐值，默认使用用户名就可
     */
    public static String encrypt(String password, String salt) throws Exception {
        return encryptAES(MD5(salt + ZYD_SECURITY_KEY), password);
    }

    /**
     * AES 解密
     * @param encryptPassword 加密后的密码
     * @param salt 盐值，默认使用用户名就可
     */
    public static String decrypt(String encryptPassword, String salt) throws Exception {
        return decryptAES(MD5(salt + ZYD_SECURITY_KEY), encryptPassword);
    }

    /**
     * <p> : AES加密
     * @author : blackcat
     * @date : 2020/1/18 14:47
     * @param passwd 加密的密钥,
     * @param content 需要加密的字符串
     * @return 返回Base64转码后的加密数据
    */
    public static String encryptAES(String passwd, String content) throws Exception {
        // 创建密码器
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        byte[] byteContent = content.getBytes("utf-8");
        // 初始化为加密模式的密码器
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(passwd));
        // 加密
        byte[] result = cipher.doFinal(byteContent);
        //通过Base64转码返回
        return Base64.encodeBase64String(result);
    }

    /**
     * <p> : AES解密
     * @author : blackcat
     * @date : 2020/1/18 14:46
     * @param passwd 加密的密钥
     * @param encrypted 已加密的密文
     * @return 返回解密后的数据
    */
    public static String decryptAES(String passwd, String encrypted) throws Exception {
        //实例化
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(passwd));
        //执行操作
        byte[] result = cipher.doFinal(Base64.decodeBase64(encrypted));
        return new String(result, "utf-8");
    }

    /**
     * <p> : AES生成加密秘钥
     * @author : blackcat
     * @date : 2020/1/18 14:45
     * @param password 密码字符
     * @return 加密秘钥
    */
    private static SecretKeySpec getSecretKey(final String password) throws NoSuchAlgorithmException {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        // javax.crypto.BadPaddingException: Given final block not properly padded解决方案
        // https://www.cnblogs.com/zempty/p/4318902.html - 用此法解决的
        // https://www.cnblogs.com/digdeep/p/5580244.html - 留作参考吧
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        //AES 要求密钥长度为 128
        kg.init(128, random);
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        // 转换为AES专用密钥
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }

    /**
     * <p> : 通过盐值对字符串进行MD5加密
     * @author : blackcat
     * @date : 2020/1/18 14:44
     * @param param 需要加密的字符串
     * @param salt 盐值
     * @return java.lang.String
    */
    public static String MD5(String param, String salt) {
        return MD5(param + salt);
    }

    /**
     * <p> : MD5加密字符串
     * @author : blackcat
     * @date : 2020/1/18 14:44
     * @param s 字符串
     * @return 加密字符串
    */
    public static String MD5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
