package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.RedPacketDetailDao;
import com.effecia.modules.chat.entity.RedPacketDetailEntity;
import com.effecia.modules.chat.service.RedPacketDetailService;



@Service("redPacketDetailService")
public class RedPacketDetailServiceImpl implements RedPacketDetailService {
	@Autowired
	private RedPacketDetailDao redPacketDetailDao;
	
	@Override
	public RedPacketDetailEntity queryObject(Integer rid){
		return redPacketDetailDao.queryObject(rid);
	}
	
	@Override
	public List<RedPacketDetailEntity> queryList(Map<String, Object> map){
		return redPacketDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return redPacketDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(RedPacketDetailEntity redPacketDetail){
		redPacketDetailDao.save(redPacketDetail);
	}
	
	@Override
	public void update(RedPacketDetailEntity redPacketDetail){
		redPacketDetailDao.update(redPacketDetail);
	}
	
	@Override
	public void delete(Integer rid){
		redPacketDetailDao.delete(rid);
	}
	
	@Override
	public void deleteBatch(Integer[] rids){
		redPacketDetailDao.deleteBatch(rids);
	}
	
}
