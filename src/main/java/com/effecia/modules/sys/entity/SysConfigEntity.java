package com.effecia.modules.sys.entity;


import org.hibernate.validator.constraints.NotBlank;

/**
 * 系统配置信息
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017年110月4日 下午6:43:36
 */
public class SysConfigEntity {
	private Long id;
	@NotBlank(message="参数名不能为空")
	private String key;
	@NotBlank(message="参数值不能为空")
	private String value; 
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
