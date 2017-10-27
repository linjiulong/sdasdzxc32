package com.effecia.common.netty.consts.po;

import java.util.HashMap;
import java.util.Map;

public class SiteRequestObj {
	private String hashCode;
	private String command;
	private Map<String, Object> params = new HashMap<String, Object>();
	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}


}