package com.effecia.common.netty.consts.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.effecia.common.netty.client.SubReqClient;
import com.effecia.common.netty.server.TcpServer;

import io.netty.channel.ChannelHandlerContext;

public class NettyCache {
	
	private static ConcurrentMap<String,ChannelHandlerContext> channels = new ConcurrentHashMap<>();
    private static TcpServer server = new TcpServer();
	private static SubReqClient client = new SubReqClient();

	public static ConcurrentMap<String, ChannelHandlerContext> getChannels() {
		return channels;
	}

	public static void setChannels(ConcurrentMap<String, ChannelHandlerContext> channels) {
		NettyCache.channels = channels;
	}

	public static SubReqClient getClient() {
		return client;
	}

	public static TcpServer getServer() {
		return server;
	}

}

