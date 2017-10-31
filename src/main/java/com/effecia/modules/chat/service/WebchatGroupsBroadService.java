package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatGroupsBroadEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-30 15:39:59
 */
public interface WebchatGroupsBroadService {
	
	WebchatGroupsBroadEntity queryObject(Integer id);
	
	List<WebchatGroupsBroadEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatGroupsBroadEntity webchatGroupsBroad);
	
	void update(WebchatGroupsBroadEntity webchatGroupsBroad);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
