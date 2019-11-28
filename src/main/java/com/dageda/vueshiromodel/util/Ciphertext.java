package com.dageda.vueshiromodel.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @ClassName Ciphertext
 * @Description: 算密文
 * @Author 邹捷
 * @Date 2019/11/20
 * @Version V1.0
 **/
public class Ciphertext {
    /**
     * 算密文
     * @param password  密码
     * @param userName  用户名
     * @return
     */
    public static String getCiphertext(String password,String userName){
        String algorithmName = "MD5";//加密算法
        Object source = password;//要加密的密码
        Object salt = userName;//盐值，一般都是用户名或者userid，要保证唯一
        int hashIterations = 1024;//加密次数
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        return simpleHash.toString();
    }
}
