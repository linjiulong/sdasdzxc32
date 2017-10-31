package com.effecia.modules.sys.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.effecia.common.validator.group.AddGroup;
import com.effecia.common.validator.group.UpdateGroup;


/**
 * 包网管理
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-06-20 15:23:47
 */
public class SysDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//包网ID
	private Long deptId;
	//上级包网ID，一级包网为0
	private Long parentId;
	//包网名称
	@NotBlank(message="包网代号不能为空")
	private String name;
	//上级包网名称
	private String parentName;
	//排序
	private Integer orderNum;
	/**
	 * ztree属性
	 */
	private Boolean open;

	private List<?> list;

	//标识
	@NotBlank(message="HashCode不能为空")
	private String hashcode;
	
	//客服聊天
	@NotBlank(message="客服聊天地址")
	private String serviceurl;
	
	//现金网登陆请求地址
	@NotBlank(message="请求路径不能为空!")
	private String cashUrl;
	
	
	private String remark;
	

	
	
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：上级包网ID，一级包网为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级包网ID，一级包网为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：包网名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：包网名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public String getServiceurl() {
		return serviceurl;
	}

	public void setServiceurl(String serviceurl) {
		this.serviceurl = serviceurl;
	}

	

	public String getCashUrl() {
		return cashUrl;
	}

	public void setCashUrl(String cashUrl) {
		this.cashUrl = cashUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysDeptEntity [deptId=" + deptId + ", parentId=" + parentId + ", name=" + name + ", parentName="
				+ parentName + ", orderNum=" + orderNum + ", open=" + open + ", list=" + list + ", hashcode=" + hashcode
				+ ", serviceurl=" + serviceurl + ", cashUrl=" + cashUrl + ", remark=" + remark + "]";
	}

 

 
 
	
	

	 
	
}
