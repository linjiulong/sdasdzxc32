package com.effecia.common.netty.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.effecia.common.netty.client.SubReqClient;
import com.effecia.common.netty.consts.cache.NettyCache;
import com.effecia.common.netty.consts.po.common.NettyCommandPo;
import com.google.gson.Gson;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

@Sharable
public class SubReqClientHandler extends SimpleChannelInboundHandler<NettyCommandPo>{

	private static Logger logger = LoggerFactory.getLogger(SubReqClientHandler.class);
    private static Gson gson=new Gson();

	private SubReqClient client;
    public SubReqClientHandler(SubReqClient subReqClient) {
        this.client = subReqClient;
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
            logger.info("[Connect To The Server] [Id:"+ctx.channel().id().asLongText()+"]");
            NettyCache.getChannels().put("client",ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    //断线重连的关键一点是检测连接是否已经断开.因此我们重写了channelInactive方法.当 TCP连接断开时,
    //会回调 channelInactive方法,因此我们在这个方法中调用 client.doConnect()来进行重连.
//    @Override
//	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//		super.channelInactive(ctx);
//		client.doConnect();
//	}

    @Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        final EventLoop loop = ctx.channel().eventLoop(); 
        loop.schedule(new Runnable() { 
            @Override 
            public void run() { 
            	client.doConnect(); 
            } 
        }, 1, TimeUnit.SECONDS);
	}

	/**  读写空闲时间超过指定时间会触发这个方法，用于心跳检测      **/
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {  //判断evt事件是不是IdleStateEvent事件;
			IdleStateEvent event = (IdleStateEvent) evt; 
			if (event.state() == IdleState.READER_IDLE){  //继续判断是读空闲事件还是写空闲事件还是读写空闲事件,根据不同事件类型发起相应的操作
				logger.info("[Client read idle]");
			} else if (event.state() == IdleState.WRITER_IDLE){   
				logger.info("[Client write idle]");
		    }else if (event.state() == IdleState.ALL_IDLE){
		    	logger.info("[All idle]");
		    }
			
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, NettyCommandPo msg) throws Exception {
		logger.info("[received] [Server] [message] - ["+gson.toJson(msg)+"]");
		String commandType = msg.getHeader().getCommandType();
		if("BACK".equals(commandType)){
			msg.getHeader().setCommandType("BACK");
			msg.getHeader().setRequestType("RESPONSE");
			msg.getParameter().put("wade","client1");
			msg.getHeader().setNeedsReturn(false);
			ctx.writeAndFlush(msg);
		}
	}
	
}
