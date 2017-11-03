package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatBroadEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-11-02 11:07:34
 */
public interface WebchatBroadService {
	
	WebchatBroadEntity queryObject(Integer id);
	
	List<WebchatBroadEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatBroadEntity webchatBroad);
	
	void update(WebchatBroadEntity webchatBroad);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
