package com.effecia.common.netty.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author wade
 * @see 封装的netty编码类，这里对传输的对象进行序列化
 */

public class RpcEncoder extends MessageToByteEncoder<Object>{

	private static Logger logger = LoggerFactory.getLogger(RpcEncoder.class);
	private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
        if (genericClass.isInstance(in)) {
        	System.out.println("1111111111111");
            byte[] data = SerializationUtil.serialize(in);  //对传输对象进行序列化
            System.out.println("22222222222");
            out.writeInt(data.length);   //把传输数据的大小加在传输数据前（方便后面处理粘包）
            out.writeBytes(data);
            logger.info("[Encode] [Size] ["+data.length+"]");
        }
    }
}
