package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatMsgEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatMsgService {
	
	WebchatMsgEntity queryObject(Integer id);
	
	List<WebchatMsgEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatMsgEntity webchatMsg);
	
	void update(WebchatMsgEntity webchatMsg);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	

	
}
