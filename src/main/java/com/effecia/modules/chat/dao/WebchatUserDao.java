package com.effecia.modules.chat.dao;

import java.util.List;
import java.util.Map;

import com.effecia.modules.chat.entity.WebchatGroupsEntity;
import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.sys.dao.BaseDao;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatUserDao extends BaseDao<WebchatUserEntity> {
	List<WebchatUserEntity> querySelect(Map<String, Object> map);
	List<WebchatGroupsEntity> groupname(String[] ids);

}
