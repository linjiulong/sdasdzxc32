package com.effecia.common.netty.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.effecia.common.netty.codec.RpcDecoder;
import com.effecia.common.netty.codec.RpcEncoder;
import com.effecia.common.netty.consts.cache.NettyCache;
import com.effecia.common.netty.consts.po.common.NettyCommandPo;
import com.effecia.common.netty.consts.po.common.NettyHeaderBasis;
import com.effecia.common.netty.handler.SubReqClientHandler;
import com.effecia.common.netty.server.TcpServer;
import com.google.gson.Gson;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;


public class SubReqClient implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(SubReqClient.class);
    private static Bootstrap bootstrap = null;
    private static Channel channel;
    private static Gson gson=new Gson();
    public SubReqClient(){
    	
    }
    
    public void send(NettyCommandPo po){
    	System.out.println("-------");
    	ChannelHandlerContext ctx = NettyCache.getChannels().get("client");
    	logger.info("[send] [channel :"+ctx+"]");
		if(ctx != null && !ctx.isRemoved() ){
			logger.info("[Client] [Send] ["+gson.toJson(po)+"]");
			ctx.writeAndFlush(po);
		} else {
			logger.error("[ChannelHandlerContext Is Null] [Or] [ChannelHandlerContext Is Removed]");
		}	
	}

	public void connect(String host, int port) throws Exception {
		NioEventLoopGroup workGroup = null ;
        try {
            //配置client启动参数
            workGroup = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            bootstrap.group(workGroup);
            bootstrap.channel(NioSocketChannel.class);  
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
				@Override
                 protected void initChannel(SocketChannel ch){         
                     /*
                     * 禁止堆类加载器进行缓存,他在基于 OSGI 的动态模块化编程中经常使用,由于 OSGI 可以进行热部署和热升级,当某个
                     * bundle升级后,它对应的类加载器也将一起升级,因此在动态模块化的编程过程中,很少对类加载器进行缓存,因为他随时可能会发生变化.
                     */
                	 //传输对象
                     //ch.pipeline().addLast(new ObjectDecoder(1024 >> 2, ClassResolvers.cacheDisabled(getClass().getClassLoader())));
                     //ch.pipeline().addLast(new ObjectEncoder());
					 ch.pipeline().addLast(new RpcEncoder(NettyCommandPo.class)); // 将 RPC 请求进行编码（为了发送请求）
	        		 ch.pipeline().addLast(new RpcDecoder(NettyCommandPo.class)); // 将 RPC 响应进行解码（为了处理响应）
                     ch.pipeline().addLast(new IdleStateHandler(0,5,0,TimeUnit.SECONDS));
                     //ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(2048,0,4,-4,0));  //RpcDecoder中已做了处理
                     ch.pipeline().addLast(new SubReqClientHandler(SubReqClient.this));
                 }
            })
            .option(ChannelOption.SO_KEEPALIVE, true);
            doConnect();
        } catch (Exception e){
        	logger.error("[Disconnect From Server] - [Wait For Reconnect Again]");
        } finally {
        	logger.error("over");
//            workGroup.shutdownGracefully();
        }
    }

	//负责客户端和服务器的 TCP 连接的建立,并且当 TCP连接失败时, doConnect会通过 "channel().eventLoop().schedule" 来延时10s后尝试重新连接.
	public void doConnect() {
        if (channel != null && channel.isActive()) {
        	
            return;
        }
        try {
        	// 发起异步链接操作
        	ChannelFuture channelFuture = bootstrap.connect("localhost",2222).sync().channel().closeFuture().sync();
     
        	
            //断线重连机制
        	channelFuture.addListener(new ChannelFutureListener() {
            	@Override
                public void operationComplete(ChannelFuture futureListener){
                    if (futureListener.isSuccess()) {
                    	channel = futureListener.channel();
                        logger.info("Connect to server successfully!");
                    } else {
                	    logger.info("Failed to connect to server, try connect after 10s");
                        futureListener.channel().eventLoop().schedule(new Runnable() {
                            @Override
                            public void run() {
                                doConnect();
                            }
                        },1,TimeUnit.SECONDS);
                    }
                 }
             });
        	
        } catch (Exception e){
        	logger.error("[Lost] [Connection] - [ready to connect again]");
        }
	}
	
	
	public static void main(String[] args) {
		try {
			Thread t = new Thread(new SubReqClient());
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			connect("localhost",2222);
		} catch (Exception e) {
			logger.error("[Connect To Server Error]");
		}
	}
    
}