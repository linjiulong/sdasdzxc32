package com.effecia.common.netty.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.effecia.common.netty.consts.cache.NettyCache;
import com.effecia.common.netty.consts.po.common.NettyCommandPo;
import com.effecia.common.netty.consts.po.common.NettyHeader;
import com.google.gson.Gson;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class SubReqServerHandler extends SimpleChannelInboundHandler<NettyCommandPo>{

	private static Logger logger = LoggerFactory.getLogger(SubReqServerHandler.class);
    private static Gson gson=new Gson();

    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
	}

	/**  读写空闲时间超过指定时间会触发这个方法，用于心跳检测      **/
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {  //判断evt事件是不是IdleStateEvent事件;
			IdleStateEvent event = (IdleStateEvent) evt; 
			if (event.state() == IdleState.READER_IDLE){  //继续判断是读空闲事件还是写空闲事件还是读写空闲事件,根据不同事件类型发起相应的操作
				logger.info("[Server read idle]");
			} else if (event.state() == IdleState.WRITER_IDLE){   
				logger.info("[Server write idle]");
		    }else if (event.state() == IdleState.ALL_IDLE){
		    	logger.info("[All idle]");
		    }
		}
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, NettyCommandPo msg) throws Exception {
		logger.info("[Received] [Client] [Message] - ["+gson.toJson(msg)+"]");
		NettyHeader head = msg.getHeader();
		String requestType = head.getRequestType();
		if(requestType.equals("REGISTER")){
			logger.info("[ONE] [Client] [Register] [Succeed]");
		}
		if(head.needsReturn()){
		   head.setCommandType("BACK");
		   head.setReturnCode(0);
		   head.setNeedsReturn(false);
		   head.setSendTime(new Date());
		   head.setRequestType("REQUEST");
		   ctx.writeAndFlush(msg);
		}
	}

	/** 连接建立时候触发 **/
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("[One Client Connect To Server] [Id:"+ctx.channel().id().asLongText()+"] ");
		NettyCache.getChannels().put("server",ctx);
	}

}