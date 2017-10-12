package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatUserDetailDao;
import com.effecia.modules.chat.entity.WebchatUserDetailEntity;
import com.effecia.modules.chat.service.WebchatUserDetailService;



@Service("webchatUserDetailService")
public class WebchatUserDetailServiceImpl implements WebchatUserDetailService {
	@Autowired
	private WebchatUserDetailDao webchatUserDetailDao;
	
	@Override
	public WebchatUserDetailEntity queryObject(Integer id){
		return webchatUserDetailDao.queryObject(id);
	}
	
	@Override
	public List<WebchatUserDetailEntity> queryList(Map<String, Object> map){
		return webchatUserDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatUserDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatUserDetailEntity webchatUserDetail){
		webchatUserDetailDao.save(webchatUserDetail);
	}
	
	@Override
	public void update(WebchatUserDetailEntity webchatUserDetail){
		webchatUserDetailDao.update(webchatUserDetail);
	}
	
	@Override
	public void delete(Integer id){
		webchatUserDetailDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatUserDetailDao.deleteBatch(ids);
	}
	
}
