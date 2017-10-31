package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.RedPacketEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-31 16:40:37
 */
public interface RedPacketService {
	
	RedPacketEntity queryObject(Integer id);
	
	List<RedPacketEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RedPacketEntity redPacket);
	
	void update(RedPacketEntity redPacket);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
