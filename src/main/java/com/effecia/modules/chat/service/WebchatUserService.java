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
public interface WebchatUserService {
	
	WebchatUserEntity queryObject(Integer id);
	
	List<WebchatUserEntity> queryList(Map<String, Object> map);

	List<WebchatGroupsEntity> groupname(String[] ids);

	List<WebchatUserEntity> querySelect(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatUserEntity webchatUser);
	
	void update(WebchatUserEntity webchatUser);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
