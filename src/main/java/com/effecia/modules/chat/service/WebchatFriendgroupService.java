package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatFriendgroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatFriendgroupService {
	
	WebchatFriendgroupEntity queryObject(Integer id);
	
	List<WebchatFriendgroupEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatFriendgroupEntity webchatFriendgroup);
	
	void update(WebchatFriendgroupEntity webchatFriendgroup);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
