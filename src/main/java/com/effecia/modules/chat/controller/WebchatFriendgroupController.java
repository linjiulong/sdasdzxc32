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

import com.effecia.modules.chat.entity.WebchatFriendgroupEntity;
import com.effecia.modules.chat.service.WebchatFriendgroupService;
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
@RequestMapping("webchatfriendgroup")
public class WebchatFriendgroupController {
	@Autowired
	private WebchatFriendgroupService webchatFriendgroupService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatfriendgroup:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatFriendgroupEntity> webchatFriendgroupList = webchatFriendgroupService.queryList(query);
		int total = webchatFriendgroupService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatFriendgroupList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatfriendgroup:info")
	public R info(@PathVariable("id") Integer id){
		WebchatFriendgroupEntity webchatFriendgroup = webchatFriendgroupService.queryObject(id);
		
		return R.ok().put("webchatFriendgroup", webchatFriendgroup);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatfriendgroup:save")
	public R save(@RequestBody WebchatFriendgroupEntity webchatFriendgroup){
		webchatFriendgroupService.save(webchatFriendgroup);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatfriendgroup:update")
	public R update(@RequestBody WebchatFriendgroupEntity webchatFriendgroup){
		webchatFriendgroupService.update(webchatFriendgroup);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatfriendgroup:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatFriendgroupService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
