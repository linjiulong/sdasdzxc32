package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatUserDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatUserDetailService {
	
	WebchatUserDetailEntity queryObject(Integer id);
	
	List<WebchatUserDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatUserDetailEntity webchatUserDetail);
	
	void update(WebchatUserDetailEntity webchatUserDetail);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
