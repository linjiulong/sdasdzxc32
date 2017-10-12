package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public class WebchatUserDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//会员ID
	private Integer webchatUid;
	//登录次数
	private Integer count;
	//
	private Integer roleId;
	//0 禁用 1 正常
	private Integer wStatus;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：会员ID
	 */
	public void setWebchatUid(Integer webchatUid) {
		this.webchatUid = webchatUid;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getWebchatUid() {
		return webchatUid;
	}
	/**
	 * 设置：登录次数
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：登录次数
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 设置：0 禁用 1 正常
	 */
	public void setWStatus(Integer wStatus) {
		this.wStatus = wStatus;
	}
	/**
	 * 获取：0 禁用 1 正常
	 */
	public Integer getWStatus() {
		return wStatus;
	}
}
