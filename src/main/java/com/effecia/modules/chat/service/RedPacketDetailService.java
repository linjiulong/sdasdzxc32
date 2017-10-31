package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.RedPacketDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-31 16:40:37
 */
public interface RedPacketDetailService {
	
	RedPacketDetailEntity queryObject(Integer rid);
	
	List<RedPacketDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RedPacketDetailEntity redPacketDetail);
	
	void update(RedPacketDetailEntity redPacketDetail);
	
	void delete(Integer rid);
	
	void deleteBatch(Integer[] rids);
}
