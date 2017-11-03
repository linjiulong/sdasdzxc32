package com.effecia.modules.chat.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-11-02 11:07:34
 */
public class WebchatBroadEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//广播内容
	private String msg;
	//时间段-开始时间
	private Date beginTime;
	//时间段-结束时间
	private Date endTime;
	//-1 删除   0 过期 1 正常
	private Integer bState;
	//时间段内播放次数
	private Integer frequency;

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
	 * 设置：广播内容
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：广播内容
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置：时间段-开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：时间段-开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：时间段-结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：时间段-结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：-1 删除   0 过期 1 正常
	 */
	public void setBState(Integer bState) {
		this.bState = bState;
	}
	/**
	 * 获取：-1 删除   0 过期 1 正常
	 */
	public Integer getBState() {
		return bState;
	}
	/**
	 * 设置：时间段内播放次数
	 */
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	/**
	 * 获取：时间段内播放次数
	 */
	public Integer getFrequency() {
		return frequency;
	}
	 
}
