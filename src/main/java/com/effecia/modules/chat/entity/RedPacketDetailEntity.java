package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-31 16:40:37
 */
public class RedPacketDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//所领红包ID
	private Integer rid;
	//会员id 收红包人ID
	private Integer uid;
	//领取金额
	private BigDecimal amount;
	//领取时间
	private Date time;

	/**
	 * 设置：所领红包ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * 获取：所领红包ID
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * 设置：会员id 收红包人ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员id 收红包人ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：领取金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：领取金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：领取时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：领取时间
	 */
	public Date getTime() {
		return time;
	}
}
