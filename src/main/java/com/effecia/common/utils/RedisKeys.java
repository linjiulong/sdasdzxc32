package com.effecia.common.utils;

/**
 * Redis所有Keys
 *
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key){
        return "sessionid:" + key;
    }
}
