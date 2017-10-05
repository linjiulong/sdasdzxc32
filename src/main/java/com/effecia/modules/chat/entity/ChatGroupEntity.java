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
public class ChatGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//群名
	private String title;
	//群号
	private String dataId;
	//群主ID
	private String userId;

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
	 * 设置：群名
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：群名
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：群号
	 */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	/**
	 * 获取：群号
	 */
	public String getDataId() {
		return dataId;
	}
	/**
	 * 设置：群主ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：群主ID
	 */
	public String getUserId() {
		return userId;
	}
}
