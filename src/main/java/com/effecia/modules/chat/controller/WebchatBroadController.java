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

import com.effecia.modules.chat.entity.WebchatBroadEntity;
import com.effecia.modules.chat.service.WebchatBroadService;
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
@RequestMapping("webchatbroad")
public class WebchatBroadController {
	@Autowired
	private WebchatBroadService webchatBroadService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatbroad:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatBroadEntity> webchatBroadList = webchatBroadService.queryList(query);
		int total = webchatBroadService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatBroadList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatbroad:info")
	public R info(@PathVariable("id") Integer id){
		WebchatBroadEntity webchatBroad = webchatBroadService.queryObject(id);
		
		return R.ok().put("webchatBroad", webchatBroad);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatbroad:save")
	public R save(@RequestBody WebchatBroadEntity webchatBroad){
		webchatBroadService.save(webchatBroad);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatbroad:update")
	public R update(@RequestBody WebchatBroadEntity webchatBroad){
		webchatBroadService.update(webchatBroad);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatbroad:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatBroadService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
