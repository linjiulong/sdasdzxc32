package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-04 17:35:30
 */
public class ChatRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//群号ID
	private Integer groupId;
	//用户ID
	private Integer userId;
	//发言时间
	private Date cTime;
	//昵称
	private String nick;
	//内容
	private String content;

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
	 * 设置：群号ID
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * 获取：群号ID
	 */
	public Integer getGroupId() {
		return groupId;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：发言时间
	 */
	public void setCTime(Date cTime) {
		this.cTime = cTime;
	}
	/**
	 * 获取：发言时间
	 */
	public Date getCTime() {
		return cTime;
	}
	/**
	 * 设置：昵称
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * 获取：昵称
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
}
