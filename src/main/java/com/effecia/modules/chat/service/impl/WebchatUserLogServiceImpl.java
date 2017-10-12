package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatUserLogDao;
import com.effecia.modules.chat.entity.WebchatUserLogEntity;
import com.effecia.modules.chat.service.WebchatUserLogService;



@Service("webchatUserLogService")
public class WebchatUserLogServiceImpl implements WebchatUserLogService {
	@Autowired
	private WebchatUserLogDao webchatUserLogDao;
	
	@Override
	public WebchatUserLogEntity queryObject(Integer id){
		return webchatUserLogDao.queryObject(id);
	}
	
	@Override
	public List<WebchatUserLogEntity> queryList(Map<String, Object> map){
		return webchatUserLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatUserLogDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatUserLogEntity webchatUserLog){
		webchatUserLogDao.save(webchatUserLog);
	}
	
	@Override
	public void update(WebchatUserLogEntity webchatUserLog){
		webchatUserLogDao.update(webchatUserLog);
	}
	
	@Override
	public void delete(Integer id){
		webchatUserLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatUserLogDao.deleteBatch(ids);
	}
	
}
