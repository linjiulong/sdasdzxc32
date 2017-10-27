package com.effecia.common.netty.consts.po.common;

import java.util.HashMap;
import java.util.Map;
/**
 * @author xiaobo
 * @see 通讯传输共用po类
 */
public class NettyCommandPo{
	
	private NettyHeader header;//命令头部信息
	private Map<String, Object> parameter = new HashMap<String, Object>();//命令数据主体
	
	public Map<String, Object> getParameter() {
		return parameter;
	}
	public void setParameter(Map<String, Object> parameter) {
		this.parameter = parameter;
	}
	public NettyHeader getHeader() {
		return header;
	}
	public void setHeader(NettyHeader header) {
		this.header = header;
	}
}
