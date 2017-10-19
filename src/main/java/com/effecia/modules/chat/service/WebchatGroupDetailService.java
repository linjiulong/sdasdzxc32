package com.effecia.modules.chat.service;

import com.effecia.modules.chat.entity.WebchatGroupDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatGroupDetailService {
	
	WebchatGroupDetailEntity queryObject(Integer gid);
	
	List<WebchatGroupDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WebchatGroupDetailEntity webchatGroupDetail);
	
	void update(WebchatGroupDetailEntity webchatGroupDetail);
	
	void delete(Integer gid);
	
	void deleteBatch(Map<String,Object> map);
	
	//群人数
	int group_quantity(int gid);
	
	
	//查看该会员在该群的信息
	WebchatGroupDetailEntity queryFindObject(Map<String,Object> map);

	
	
	
}
