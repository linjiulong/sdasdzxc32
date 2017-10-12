package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatMessageboxEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatMessageboxService {
	
	WebchatMessageboxEntity queryObject(Integer id);
	
	List<WebchatMessageboxEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatMessageboxEntity webchatMessagebox);
	
	void update(WebchatMessageboxEntity webchatMessagebox);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
