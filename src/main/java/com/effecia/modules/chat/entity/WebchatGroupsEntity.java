package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotBlank;

import com.effecia.common.validator.group.AddGroup;
import com.effecia.common.validator.group.UpdateGroup;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public class WebchatGroupsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//群名
	@NotBlank(message="群名不能为空!", groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	//头像
	@NotBlank(message="头像必须上传!", groups = {AddGroup.class})
	private String headphoto;
	//群介绍
	@NotBlank(message="群介绍不能为空!", groups = {AddGroup.class, UpdateGroup.class})
	private String desc;
	//群主
	private Integer ownerUid;
	//建立时间
	private Date addtime;
	//0 游客 1普通群
	private Integer level;
	
	//邀请成员名单列表
	private String users;
	
	//群人数
	private Integer quantity;
	
	//群主昵称
	private String username;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：群名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：群名
	 */
	public String getName() {
		return name;
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
	 * 设置：群介绍
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：群介绍
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：群主
	 */
	public void setOwnerUid(Integer ownerUid) {
		this.ownerUid = ownerUid;
	}
	/**
	 * 获取：群主
	 */
	public Integer getOwnerUid() {
		return ownerUid;
	}
	/**
	 * 设置：建立时间
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：建立时间
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：0 游客 1普通群
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：0 游客 1普通群
	 */
	public Integer getLevel() {
		return level;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "WebchatGroupsEntity [id=" + id + ", name=" + name + ", headphoto=" + headphoto + ", desc=" + desc
				+ ", ownerUid=" + ownerUid + ", addtime=" + addtime + ", level=" + level + ", users=" + users
				+ ", quantity=" + quantity + ", username=" + username + "]";
	}
	 
	
	
	
}
