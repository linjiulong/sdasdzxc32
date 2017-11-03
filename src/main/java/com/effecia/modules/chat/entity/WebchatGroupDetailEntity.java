package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-11-01 11:29:24
 */
public class WebchatGroupDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer gid;
	//群成员
	private Integer uid;
	//加入时间
	private Date addTime;
	// 0 正常 1禁言
	private Integer gStatus;
	//禁言时长
	private Date bannedTime;
	//最后发言时间
	private Date speakTime;
	//1 普通会员 2 管理员   0群主
	private Integer level;
	//群名片
	private String nickName;
	
	//群成员管理功能
	private String qfunction;
	//会员列表
	private String users;
	//对应包网
	private Integer dept_id;
	

	/**
	 * 设置：
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	/**
	 * 获取：
	 */
	public Integer getGid() {
		return gid;
	}
	/**
	 * 设置：群成员
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：群成员
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：加入时间
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：加入时间
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置： 0 正常 1禁言
	 */
	public void setGStatus(Integer gStatus) {
		this.gStatus = gStatus;
	}
	/**
	 * 获取： 0 正常 1禁言
	 */
	public Integer getGStatus() {
		return gStatus;
	}
	/**
	 * 设置：禁言时长
	 */
	public void setBannedTime(Date bannedTime) {
		this.bannedTime = bannedTime;
	}
	/**
	 * 获取：禁言时长
	 */
	public Date getBannedTime() {
		return bannedTime;
	}
	/**
	 * 设置：最后发言时间
	 */
	public void setSpeakTime(Date speakTime) {
		this.speakTime = speakTime;
	}
	/**
	 * 获取：最后发言时间
	 */
	public Date getSpeakTime() {
		return speakTime;
	}
	/**
	 * 设置：1 普通会员 2 管理员   0群主
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：1 普通会员 2 管理员   0群主
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：群名片
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：群名片
	 */
	public String getNickName() {
		return nickName;
	}
	public Integer getgStatus() {
		return gStatus;
	}
	public void setgStatus(Integer gStatus) {
		this.gStatus = gStatus;
	}
	public String getQfunction() {
		return qfunction;
	}
	public void setQfunction(String qfunction) {
		this.qfunction = qfunction;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "WebchatGroupDetailEntity [gid=" + gid + ", uid=" + uid + ", addTime=" + addTime + ", gStatus=" + gStatus
				+ ", bannedTime=" + bannedTime + ", speakTime=" + speakTime + ", level=" + level + ", nickName="
				+ nickName + ", qfunction=" + qfunction + ", users=" + users + ", dept_id=" + dept_id + "]";
	}
	
}
