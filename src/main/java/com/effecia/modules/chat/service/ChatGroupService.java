package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.ChatGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-04 17:35:30
 */
public interface ChatGroupService {
	
	ChatGroupEntity queryObject(Integer id);
	
	List<ChatGroupEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChatGroupEntity chatGroup);
	
	void update(ChatGroupEntity chatGroup);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
