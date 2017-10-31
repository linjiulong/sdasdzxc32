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

import com.effecia.modules.chat.entity.WebchatFriendgroupDetailEntity;
import com.effecia.modules.chat.service.WebchatFriendgroupDetailService;
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
@RequestMapping("webchatfriendgroupdetail")
public class WebchatFriendgroupDetailController {
	@Autowired
	private WebchatFriendgroupDetailService webchatFriendgroupDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatfriendgroupdetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatFriendgroupDetailEntity> webchatFriendgroupDetailList = webchatFriendgroupDetailService.queryList(query);
		int total = webchatFriendgroupDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatFriendgroupDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatfriendgroupdetail:info")
	public R info(@PathVariable("id") Integer id){
		WebchatFriendgroupDetailEntity webchatFriendgroupDetail = webchatFriendgroupDetailService.queryObject(id);
		
		return R.ok().put("webchatFriendgroupDetail", webchatFriendgroupDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatfriendgroupdetail:save")
	public R save(@RequestBody WebchatFriendgroupDetailEntity webchatFriendgroupDetail){
		
		
		
		webchatFriendgroupDetailService.save(webchatFriendgroupDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatfriendgroupdetail:update")
	public R update(@RequestBody WebchatFriendgroupDetailEntity webchatFriendgroupDetail){
		webchatFriendgroupDetailService.update(webchatFriendgroupDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatfriendgroupdetail:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatFriendgroupDetailService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
