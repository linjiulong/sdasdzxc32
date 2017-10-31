package com.effecia.modules.chat.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.effecia.modules.chat.entity.WebchatGroupsBroadEntity;
import com.effecia.modules.chat.service.WebchatGroupsBroadService;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-30 15:39:59
 */
@RestController
@RequestMapping("webchatgroupsbroad")
public class WebchatGroupsBroadController {
	@Autowired
	private WebchatGroupsBroadService webchatGroupsBroadService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatgroupsbroad:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatGroupsBroadEntity> webchatGroupsBroadList = webchatGroupsBroadService.queryList(query);
		int total = webchatGroupsBroadService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatGroupsBroadList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatgroupsbroad:info")
	public R info(@PathVariable("id") Integer id){
		WebchatGroupsBroadEntity webchatGroupsBroad = webchatGroupsBroadService.queryObject(id);
		
		return R.ok().put("webchatGroupsBroad", webchatGroupsBroad);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatgroupsbroad:save")
	public R save(@RequestBody WebchatGroupsBroadEntity webchatGroupsBroad){
		webchatGroupsBroadService.save(webchatGroupsBroad);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatgroupsbroad:update")
	public R update(@RequestBody WebchatGroupsBroadEntity webchatGroupsBroad){
		webchatGroupsBroadService.update(webchatGroupsBroad);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatgroupsbroad:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatGroupsBroadService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
