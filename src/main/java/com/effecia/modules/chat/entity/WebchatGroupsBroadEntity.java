package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-30 15:39:59
 */
public class WebchatGroupsBroadEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//群ID
	private Integer gid;
	//广播ID
	private Integer bid;

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
	 * 设置：群ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	/**
	 * 获取：群ID
	 */
	public Integer getGid() {
		return gid;
	}
	/**
	 * 设置：广播ID
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	/**
	 * 获取：广播ID
	 */
	public Integer getBid() {
		return bid;
	}
}
