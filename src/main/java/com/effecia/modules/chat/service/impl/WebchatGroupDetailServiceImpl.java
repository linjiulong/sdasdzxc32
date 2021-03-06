package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatGroupDetailDao;
import com.effecia.modules.chat.entity.WebchatGroupDetailEntity;
import com.effecia.modules.chat.service.WebchatGroupDetailService;



@Service("webchatGroupDetailService")
public class WebchatGroupDetailServiceImpl implements WebchatGroupDetailService {
	@Autowired
	private WebchatGroupDetailDao webchatGroupDetailDao;
	
	@Override
	public WebchatGroupDetailEntity queryObject(Integer gid){
		return webchatGroupDetailDao.queryObject(gid);
	}
	
	@Override
	public List<WebchatGroupDetailEntity> queryList(Map<String, Object> map){
		return webchatGroupDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatGroupDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatGroupDetailEntity webchatGroupDetail){
		webchatGroupDetailDao.save(webchatGroupDetail);
	}
	
	@Override
	public void update(WebchatGroupDetailEntity webchatGroupDetail){
		webchatGroupDetailDao.update(webchatGroupDetail);
	}
	
	@Override
	public void delete(Integer gid){
		webchatGroupDetailDao.delete(gid);
	}
	
	@Override
	public 	void deleteBatch(Map<String,Object> map){
		webchatGroupDetailDao.deleteBatch(map);
	}

	@Override
	public int group_quantity(int gid) {
		return webchatGroupDetailDao.group_quantity(gid);
	}


	@Override
	public WebchatGroupDetailEntity queryFindObject(Map<String, Object> map) {
		return webchatGroupDetailDao.queryFindObject(map);
	}

	@Override
	public void group_detail(Integer uid) {
		webchatGroupDetailDao.group_detail(uid);		
	}

	@Override
	public int updategroup(WebchatGroupDetailEntity webchatGroupDetail) {
		return webchatGroupDetailDao.updategroup(webchatGroupDetail);
			
	}
	
}
