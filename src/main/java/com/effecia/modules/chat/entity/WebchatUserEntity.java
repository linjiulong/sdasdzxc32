package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-26 17:48:29
 */
public class WebchatUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private Long id;
	//用户名
	private String username;
	//密码
	private String password;
	//个人介绍
	private String sign;
	//头像
	private String headphoto;
	//注册时间
	private Date addTime;
	//0 离线 1在线 状态
	private Integer online;
	//包网id标识
	private Long deptId;
	//盐
	private String salt;
	//登录次数
	private Integer count;
	//状态 0禁用 1正常
	private Integer status;
	//金额
	private BigDecimal limits;
	
	/**
	 * 角色ID列表
	 */
	private List<Long> roleIdList;
	
	
	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}
	
	/**
	 * 设置：用户ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
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
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getAddTime() {
		return addTime;
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
	/**
	 * 设置：包网id标识
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：包网id标识
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：盐
	 */
	public String getSalt() {
		return salt;
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
	 * 设置：状态 0禁用 1正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0禁用 1正常
	 */
	public Integer getStatus() {
		return status;
	}
	public BigDecimal getLimits() {
		return limits;
	}
	public void setLimits(BigDecimal limits) {
		this.limits = limits;
	}

	@Override
	public String toString() {
		return "WebchatUserEntity [id=" + id + ", username=" + username + ", password=" + password + ", sign=" + sign
				+ ", headphoto=" + headphoto + ", addTime=" + addTime + ", online=" + online + ", deptId=" + deptId
				+ ", salt=" + salt + ", count=" + count + ", status=" + status + ", limits=" + limits + ", roleIdList="
				+ roleIdList + "]";
	}
	 
	 
}
