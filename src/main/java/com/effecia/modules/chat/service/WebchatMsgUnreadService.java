package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatMsgUnreadEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatMsgUnreadService {
	
	WebchatMsgUnreadEntity queryObject(Integer id);
	
	List<WebchatMsgUnreadEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatMsgUnreadEntity webchatMsgUnread);
	
	void update(WebchatMsgUnreadEntity webchatMsgUnread);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
