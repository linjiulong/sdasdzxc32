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

import com.effecia.modules.chat.entity.ChatGroupEntity;
import com.effecia.modules.chat.service.ChatGroupService;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-04 17:35:30
 */
@RestController
@RequestMapping("chatgroup")
public class ChatGroupController {
	@Autowired
	private ChatGroupService chatGroupService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("chatgroup:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ChatGroupEntity> chatGroupList = chatGroupService.queryList(query);
		int total = chatGroupService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(chatGroupList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("chatgroup:info")
	public R info(@PathVariable("id") Integer id){
		ChatGroupEntity chatGroup = chatGroupService.queryObject(id);
		
		return R.ok().put("chatGroup", chatGroup);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("chatgroup:save")
	public R save(@RequestBody ChatGroupEntity chatGroup){
		chatGroupService.save(chatGroup);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("chatgroup:update")
	public R update(@RequestBody ChatGroupEntity chatGroup){
		chatGroupService.update(chatGroup);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("chatgroup:delete")
	public R delete(@RequestBody Integer[] ids){
		chatGroupService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
