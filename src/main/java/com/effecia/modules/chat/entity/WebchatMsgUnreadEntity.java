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
public class WebchatMsgUnreadEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//UID=ID & gid=0 私聊 gid=id &gid=1
	private Integer id;
	//会员iD
	private Integer uid;
	//谁发的消息给该会员
	private Integer fromuser;
	//0 私聊 1 群聊
	private Integer gid;
	//发送时间
	private Date updatetime;
	//未读信息条数
	private Integer msgcount;

	/**
	 * 设置：UID=ID & gid=0 私聊 gid=id &gid=1
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：UID=ID & gid=0 私聊 gid=id &gid=1
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：会员iD
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员iD
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：谁发的消息给该会员
	 */
	public void setFromuser(Integer fromuser) {
		this.fromuser = fromuser;
	}
	/**
	 * 获取：谁发的消息给该会员
	 */
	public Integer getFromuser() {
		return fromuser;
	}
	/**
	 * 设置：0 私聊 1 群聊
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	/**
	 * 获取：0 私聊 1 群聊
	 */
	public Integer getGid() {
		return gid;
	}
	/**
	 * 设置：发送时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：发送时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：未读信息条数
	 */
	public void setMsgcount(Integer msgcount) {
		this.msgcount = msgcount;
	}
	/**
	 * 获取：未读信息条数
	 */
	public Integer getMsgcount() {
		return msgcount;
	}
}
