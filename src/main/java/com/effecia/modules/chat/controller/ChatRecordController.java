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

import com.effecia.modules.chat.entity.ChatRecordEntity;
import com.effecia.modules.chat.service.ChatRecordService;
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
@RequestMapping("chatrecord")
public class ChatRecordController {
	@Autowired
	private ChatRecordService chatRecordService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("chatrecord:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ChatRecordEntity> chatRecordList = chatRecordService.queryList(query);
		int total = chatRecordService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(chatRecordList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("chatrecord:info")
	public R info(@PathVariable("id") Integer id){
		ChatRecordEntity chatRecord = chatRecordService.queryObject(id);
		
		return R.ok().put("chatRecord", chatRecord);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("chatrecord:save")
	public R save(@RequestBody ChatRecordEntity chatRecord){
		chatRecordService.save(chatRecord);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("chatrecord:update")
	public R update(@RequestBody ChatRecordEntity chatRecord){
		chatRecordService.update(chatRecord);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("chatrecord:delete")
	public R delete(@RequestBody Integer[] ids){
		chatRecordService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
