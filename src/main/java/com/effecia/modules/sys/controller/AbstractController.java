package com.effecia.modules.sys.controller;

import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.sys.entity.SysUserEntity;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年110月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getId();
	}

	protected Long getDeptId() {
		return getUser().getDeptId();
	}
}
