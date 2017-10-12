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

import com.effecia.modules.chat.entity.WebchatMsgEntity;
import com.effecia.modules.chat.service.WebchatMsgService;
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
@RequestMapping("webchatmsg")
public class WebchatMsgController {
	@Autowired
	private WebchatMsgService webchatMsgService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatmsg:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatMsgEntity> webchatMsgList = webchatMsgService.queryList(query);
		int total = webchatMsgService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatMsgList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatmsg:info")
	public R info(@PathVariable("id") Integer id){
		WebchatMsgEntity webchatMsg = webchatMsgService.queryObject(id);
		
		return R.ok().put("webchatMsg", webchatMsg);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatmsg:save")
	public R save(@RequestBody WebchatMsgEntity webchatMsg){
		webchatMsgService.save(webchatMsg);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatmsg:update")
	public R update(@RequestBody WebchatMsgEntity webchatMsg){
		webchatMsgService.update(webchatMsg);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatmsg:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatMsgService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
