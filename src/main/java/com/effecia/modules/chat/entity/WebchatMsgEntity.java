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
public class WebchatMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//会员ID
	private Integer uid;
	//发送者ID
	private Integer fromuser;
	//群ID
	private Integer gid;
	//内容
	private String msg;
	//发送时间
	private Date addtime;

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
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：发送者ID
	 */
	public void setFromuser(Integer fromuser) {
		this.fromuser = fromuser;
	}
	/**
	 * 获取：发送者ID
	 */
	public Integer getFromuser() {
		return fromuser;
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
	 * 设置：内容
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：内容
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置：发送时间
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：发送时间
	 */
	public Date getAddtime() {
		return addtime;
	}
}
