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

import com.effecia.modules.chat.entity.WebchatMsgUnreadEntity;
import com.effecia.modules.chat.service.WebchatMsgUnreadService;
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
@RequestMapping("webchatmsgunread")
public class WebchatMsgUnreadController {
	@Autowired
	private WebchatMsgUnreadService webchatMsgUnreadService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatmsgunread:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatMsgUnreadEntity> webchatMsgUnreadList = webchatMsgUnreadService.queryList(query);
		int total = webchatMsgUnreadService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatMsgUnreadList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatmsgunread:info")
	public R info(@PathVariable("id") Integer id){
		WebchatMsgUnreadEntity webchatMsgUnread = webchatMsgUnreadService.queryObject(id);
		
		return R.ok().put("webchatMsgUnread", webchatMsgUnread);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatmsgunread:save")
	public R save(@RequestBody WebchatMsgUnreadEntity webchatMsgUnread){
		webchatMsgUnreadService.save(webchatMsgUnread);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatmsgunread:update")
	public R update(@RequestBody WebchatMsgUnreadEntity webchatMsgUnread){
		webchatMsgUnreadService.update(webchatMsgUnread);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatmsgunread:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatMsgUnreadService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
