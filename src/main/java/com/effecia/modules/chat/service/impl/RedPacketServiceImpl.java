package com.effecia.modules.chat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.dao.RedPacketDao;
import com.effecia.modules.chat.entity.RedPacketEntity;
import com.effecia.modules.chat.service.RedPacketService;



@Service("redPacketService")
public class RedPacketServiceImpl implements RedPacketService {
	@Autowired
	private RedPacketDao redPacketDao;
	
	@Override
	public RedPacketEntity queryObject(Integer id){
		return redPacketDao.queryObject(id);
	}
	
	@Override
	public List<RedPacketEntity> queryList(Map<String, Object> map){
		return redPacketDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return redPacketDao.queryTotal(map);
	}
	
	@Override
	public void save(RedPacketEntity redPacket){
		redPacketDao.save(redPacket);
	}
	
	@Override
	public void update(RedPacketEntity redPacket){
		redPacketDao.update(redPacket);
	}
	
	@Override
	public void delete(Integer id){
		redPacketDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		redPacketDao.deleteBatch(ids);
	}
	
}
