package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatApplyEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatApplyService {
	
	WebchatApplyEntity queryObject(Integer fromuser);
	
	List<WebchatApplyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatApplyEntity webchatApply);
	
	void update(WebchatApplyEntity webchatApply);
	
	void delete(Integer fromuser);
	
	void deleteBatch(Integer[] fromusers);
}
