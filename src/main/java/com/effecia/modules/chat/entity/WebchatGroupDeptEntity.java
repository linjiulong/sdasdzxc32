package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-11 11:24:45
 */
public class WebchatGroupDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//群-公司关系表
	private Integer id;
	//群号id
	private Integer groupsId;
	//所属公司id
	private Integer deptId;

	/**
	 * 设置：群-公司关系表
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：群-公司关系表
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：群号id
	 */
	public void setGroupsId(Integer groupsId) {
		this.groupsId = groupsId;
	}
	/**
	 * 获取：群号id
	 */
	public Integer getGroupsId() {
		return groupsId;
	}
	/**
	 * 设置：所属公司id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：所属公司id
	 */
	public Integer getDeptId() {
		return deptId;
	}
}
