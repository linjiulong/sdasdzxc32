package com.effecia.modules.chat.dao;

import java.util.Map;

import com.effecia.modules.chat.entity.WebchatGroupDetailEntity;
import com.effecia.modules.sys.dao.BaseDao;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatGroupDetailDao extends BaseDao<WebchatGroupDetailEntity> {
	
	//群人数
	int group_quantity(int gid);
	
	//批量删除
	void deleteBatch(Map<String,Object> map);
	
	WebchatGroupDetailEntity queryFindObject(Map<String,Object> map);
	
	void group_detail(Integer uid);
	//移动群
	int updategroup (WebchatGroupDetailEntity webchatGroupDetail);

}
