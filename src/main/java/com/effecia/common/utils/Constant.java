package com.effecia.common.utils;

/**
 * 常量
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年110月15日 下午1:23:52
 */
public class Constant {
	/** 超级管理员ID */
	public static final int SUPER_ADMIN = 1;

	/**
	 * 菜单类型
	 * 
	 * @author lin
	 * @email lin.lin@support888.net
	 * @date 2017年110月15日 下午1:24:29
	 */
    public enum MenuType {
    	/**
    	 * 目录
    	 */
    	CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2),
        /**
         * 顶部菜单
         */
        TOP(2);

        private int value;

        private MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    

}
