package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.ChatRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-04 17:35:30
 */
public interface ChatRecordService {
	
	ChatRecordEntity queryObject(Integer id);
	
	List<ChatRecordEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChatRecordEntity chatRecord);
	
	void update(ChatRecordEntity chatRecord);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
