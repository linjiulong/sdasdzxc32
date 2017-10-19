package com.effecia.modules.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effecia.modules.chat.entity.WebchatGroupsEntity;
import com.effecia.modules.chat.entity.WebchatUserEntity;
import com.effecia.modules.chat.service.WebchatGroupsService;
import com.effecia.modules.chat.service.WebchatUserService;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-07 16:02:13
 */
@RestController
@RequestMapping("api")
public class ApiLoginController {
	
	@Autowired
	private WebchatUserService webchatUserService;
	
	@Autowired
	private WebchatGroupsService webchatGroupsService;
	 
	/**
	 * 信息
	 */
	@RequestMapping("/login")
	public R info(@RequestParam Map<String, Object> params){
		 System.out.println(params);
		
		return R.ok(params);
	}
	
	
	
}
