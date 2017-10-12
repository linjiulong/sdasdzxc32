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
public class WebchatFriendgroupDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer fidOwner;
	//
	private Integer fid;
	//
	private Integer uid;

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
	 * 设置：
	 */
	public void setFidOwner(Integer fidOwner) {
		this.fidOwner = fidOwner;
	}
	/**
	 * 获取：
	 */
	public Integer getFidOwner() {
		return fidOwner;
	}
	/**
	 * 设置：
	 */
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	/**
	 * 获取：
	 */
	public Integer getFid() {
		return fid;
	}
	/**
	 * 设置：
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Integer getUid() {
		return uid;
	}
}
