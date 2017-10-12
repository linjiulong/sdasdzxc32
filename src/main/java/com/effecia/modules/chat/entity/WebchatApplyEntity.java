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
public class WebchatApplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer fromuser;
	//
	private Integer uid;
	//
	private Integer fromuserFid;
	//
	private Date addtime;
	//
	private String msg;

	/**
	 * 设置：
	 */
	public void setFromuser(Integer fromuser) {
		this.fromuser = fromuser;
	}
	/**
	 * 获取：
	 */
	public Integer getFromuser() {
		return fromuser;
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
	/**
	 * 设置：
	 */
	public void setFromuserFid(Integer fromuserFid) {
		this.fromuserFid = fromuserFid;
	}
	/**
	 * 获取：
	 */
	public Integer getFromuserFid() {
		return fromuserFid;
	}
	/**
	 * 设置：
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：
	 */
	public String getMsg() {
		return msg;
	}
}
