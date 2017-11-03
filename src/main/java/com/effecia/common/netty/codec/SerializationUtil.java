package com.effecia.common.netty.codec;

import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import com.effecia.common.utils.TimestampDelegate;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.DefaultIdStrategy;
import com.dyuproject.protostuff.runtime.Delegate;
import com.dyuproject.protostuff.runtime.RuntimeEnv;
import com.dyuproject.protostuff.runtime.RuntimeSchema;


/**
 * @author wade,
 * @see 这里采用当前序列化效率最高的protostuff来对传输对象进行序列化与反序列化。也可以根据需要自己定制化序列化方式。
 */
public class SerializationUtil{
	
    /** 时间戳转换Delegate，解决时间戳(timestamp类型的)转换后错误问题  **/
    private final static Delegate<Timestamp> TIMESTAMP_DELEGATE = new TimestampDelegate();
    private static DefaultIdStrategy idStrategy = ((DefaultIdStrategy) RuntimeEnv.ID_STRATEGY);

    //对schema做缓存，加快编解码速度
	private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();
    private static Objenesis objenesis = new ObjenesisStd(true);

	public SerializationUtil() {}
    
    static {
        idStrategy.registerDelegate(TIMESTAMP_DELEGATE);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Schema<T> getSchema(Class<T> cls) {
        Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
        if (schema == null) {
            schema = RuntimeSchema.createFrom(cls,idStrategy);
            if (schema != null) {
                cachedSchema.put(cls, schema);
            }
        }
        return schema;
    }

    /**   序列化        **/
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
    	System.out.println("SSSSS");
    	if (obj == null) {
            return null;
        }
        Class<T> cls = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = getSchema(cls);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        } finally {
            buffer.clear();
        }
    }

    /**   反序列化        **/
    public static <T> T deserialize(byte[] data, Class<T> cls) {
    	if (data == null || data.length == 0) {
            return null;
        }
        try {
            T message = (T) objenesis.newInstance(cls);
        	
            Schema<T> schema = getSchema(cls);
            //改为由Schema来实例化解码对象，没有构造函数也没有问题
            //T message = schema.newMessage();
            ProtostuffIOUtil.mergeFrom(data, message, schema);
            return message;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

}
