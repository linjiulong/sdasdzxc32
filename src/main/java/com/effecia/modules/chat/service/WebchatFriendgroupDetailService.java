package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatFriendgroupDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatFriendgroupDetailService {
	
	WebchatFriendgroupDetailEntity queryObject(Integer id);
	
	List<WebchatFriendgroupDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatFriendgroupDetailEntity webchatFriendgroupDetail);
	
	void update(WebchatFriendgroupDetailEntity webchatFriendgroupDetail);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
