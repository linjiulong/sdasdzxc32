package com.effecia.chat.pojo;

import java.util.Date;
/**
 * @author xiaobo
 * @see 通讯传输共用po类
 */
public class NettyHeaderBasis implements NettyHeader {
	
	private String version = "1.0";// mina通信协议版本号
	private String requestType;// 请求类型,注册时请使用REGISTER
	private String commandType;// 命令类型
	private String gameServerType;// 游戏类型
	private String source;// 命令源，如包网的是用SITE,gameServer的使用GAMESERVER，操盘使用AP
	private String sourceModule;// 命令源模块编码,如AG使用AG，登录前台使用RECP，快乐十分使用KLC,时时彩SSC
	private String target;// 命令目标， 同source,命令的达到处理方
	private String targetModule;// 命令目标模块编码，同sourceModule
	private String commandId;// 命令ID
	private int returnCode;//返回的code
	private boolean needsReturn;//是否需要返回确认
	private Date sendTime;//命令发送时间
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getCommandType() {
		return commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getGameServerType() {
		return gameServerType;
	}

	public void setGameServerType(String gameServerType) {
		this.gameServerType = gameServerType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceModule() {
		return sourceModule;
	}

	public void setSourceModule(String sourceModule) {
		this.sourceModule = sourceModule;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTargetModule() {
		return targetModule;
	}

	public void setTargetModule(String targetModule) {
		this.targetModule = targetModule;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	public String getVersion() {
		return version;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public boolean needsReturn() {
		return needsReturn;
	}

	public void setNeedsReturn(boolean needs) {
		this.needsReturn = needs;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "NettyHeaderBasis [version=" + version + ", requestType=" + requestType + ", commandType=" + commandType
				+ ", gameServerType=" + gameServerType + ", source=" + source + ", sourceModule=" + sourceModule
				+ ", target=" + target + ", targetModule=" + targetModule + ", commandId=" + commandId + ", returnCode="
				+ returnCode + ", needsReturn=" + needsReturn + ", sendTime=" + sendTime + "]";
	}
	
}
