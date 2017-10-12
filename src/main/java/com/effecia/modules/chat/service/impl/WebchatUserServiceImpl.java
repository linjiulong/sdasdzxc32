package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.WebchatUserDao;
import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.chat.service.WebchatUserService;



@Service("webchatUserService")
public class WebchatUserServiceImpl implements WebchatUserService {
	@Autowired
	private WebchatUserDao webchatUserDao;
	
	@Override
	public WebchatUserEntity queryObject(Integer id){
		return webchatUserDao.queryObject(id);
	}
	
	@Override
	public List<WebchatUserEntity> queryList(Map<String, Object> map){
		return webchatUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return webchatUserDao.queryTotal(map);
	}
	
	@Override
	public void save(WebchatUserEntity webchatUser){
		webchatUserDao.save(webchatUser);
	}
	
	@Override
	public void update(WebchatUserEntity webchatUser){
		webchatUserDao.update(webchatUser);
	}
	
	@Override
	public void delete(Integer id){
		webchatUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		webchatUserDao.deleteBatch(ids);
	}

	@Override
	public List<WebchatUserEntity> querySelect(Map<String, Object> map) {
		return webchatUserDao.querySelect(map);
	}
	
}
