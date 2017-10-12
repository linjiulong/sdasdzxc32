package com.effecia.modules.chat.dao;

import java.util.Map;

import com.effecia.modules.chat.entity.WebchatGroupDeptEntity;
import com.effecia.modules.sys.dao.BaseDao;

/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-11 11:24:45
 */
public interface WebchatGroupDeptDao extends BaseDao<WebchatGroupDeptEntity> {
	WebchatGroupDeptEntity queryFind(Map<String, Object> map);

}
