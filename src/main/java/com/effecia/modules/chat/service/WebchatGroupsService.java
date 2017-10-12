package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatGroupsEntity;
import com.effecia.modules.chat.entity.WebchatUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatGroupsService {
	
	WebchatGroupsEntity queryObject(Integer id);
	
	List<WebchatGroupsEntity> queryList(Map<String, Object> map);
	
	List<WebchatGroupsEntity> querySelect(Map<String, Object> map);

	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatGroupsEntity webchatGroups);
	
	void update(WebchatGroupsEntity webchatGroups);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
}
