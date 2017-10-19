package com.effecia.modules.chat.dao;

import java.util.Map;

import com.effecia.modules.chat.entity.WebchatGroupDeptEntity;
import com.effecia.modules.chat.entity.WebchatMsgEntity;
import com.effecia.modules.sys.dao.BaseDao;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
public interface WebchatMsgDao extends BaseDao<WebchatMsgEntity> {
	WebchatGroupDeptEntity queryFind(Map<String, Object> map);

}
