package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatApplyDao;
import com.effecia.modules.chat.entity.WebchatApplyEntity;
import com.effecia.modules.chat.service.WebchatApplyService;



@Service("webchatApplyService")
public class WebchatApplyServiceImpl implements WebchatApplyService {
	@Autowired
	private WebchatApplyDao webchatApplyDao;
	
	@Override
	public WebchatApplyEntity queryObject(Integer fromuser){
		return webchatApplyDao.queryObject(fromuser);
	}
	
	@Override
	public List<WebchatApplyEntity> queryList(Map<String, Object> map){
		return webchatApplyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatApplyDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatApplyEntity webchatApply){
		webchatApplyDao.save(webchatApply);
	}
	
	@Override
	public void update(WebchatApplyEntity webchatApply){
		webchatApplyDao.update(webchatApply);
	}
	
	@Override
	public void delete(Integer fromuser){
		webchatApplyDao.delete(fromuser);
	}
	
	@Override
	public void deleteBatch(Integer[] fromusers){
		webchatApplyDao.deleteBatch(fromusers);
	}
	
}
