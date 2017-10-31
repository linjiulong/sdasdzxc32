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
public class RedPacketEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//群组ID  按群查询发红包记录
	private Integer gid;
	//用户ID 发红包人ID  按发红包人来查
	private Integer uid;
	//红包总金额
	private BigDecimal amount;
	//红包个数
	private Integer num;
	//已领数据
	private Integer take;
	//红包过期时间
	private Date outTime;
	//红包发出时间
	private Date sendTime;
	//红包标题
	private String headMessage;
	//红包留言
	private String detailMessage;

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
	 * 设置：群组ID  按群查询发红包记录
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	/**
	 * 获取：群组ID  按群查询发红包记录
	 */
	public Integer getGid() {
		return gid;
	}
	/**
	 * 设置：用户ID 发红包人ID  按发红包人来查
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户ID 发红包人ID  按发红包人来查
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：红包总金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：红包总金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：红包个数
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：红包个数
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：已领数据
	 */
	public void setTake(Integer take) {
		this.take = take;
	}
	/**
	 * 获取：已领数据
	 */
	public Integer getTake() {
		return take;
	}
	/**
	 * 设置：红包过期时间
	 */
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	/**
	 * 获取：红包过期时间
	 */
	public Date getOutTime() {
		return outTime;
	}
	/**
	 * 设置：红包发出时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：红包发出时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：红包标题
	 */
	public void setHeadMessage(String headMessage) {
		this.headMessage = headMessage;
	}
	/**
	 * 获取：红包标题
	 */
	public String getHeadMessage() {
		return headMessage;
	}
	/**
	 * 设置：红包留言
	 */
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	/**
	 * 获取：红包留言
	 */
	public String getDetailMessage() {
		return detailMessage;
	}
}
