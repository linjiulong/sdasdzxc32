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
public class WebchatUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户ID
	private Integer uid;
	//用户名
	private String name;
	//密码
	private String password;
	//个人介绍
	private String sign;
	//头像
	private String headphoto;
	//注册时间
	private Date addtime;
	//0 离线 1在线 状态
	private Integer online;
	
	private String hashcode;

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
	 * 设置：用户ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：用户名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：个人介绍
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	/**
	 * 获取：个人介绍
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadphoto() {
		return headphoto;
	}
	/**
	 * 设置：注册时间
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：0 离线 1在线 状态
	 */
	public void setOnline(Integer online) {
		this.online = online;
	}
	/**
	 * 获取：0 离线 1在线 状态
	 */
	public Integer getOnline() {
		return online;
	}
	public String getHashcode() {
		return hashcode;
	}
	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}
	@Override
	public String toString() {
		return "WebchatUserEntity [id=" + id + ", uid=" + uid + ", name=" + name + ", password=" + password + ", sign="
				+ sign + ", headphoto=" + headphoto + ", addtime=" + addtime + ", online=" + online + ", hashcode="
				+ hashcode + "]";
	}
   
	
}
