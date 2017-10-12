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

import com.effecia.modules.chat.entity.WebchatMessageboxEntity;
import com.effecia.modules.chat.service.WebchatMessageboxService;
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
@RequestMapping("webchatmessagebox")
public class WebchatMessageboxController {
	@Autowired
	private WebchatMessageboxService webchatMessageboxService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("webchatmessagebox:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WebchatMessageboxEntity> webchatMessageboxList = webchatMessageboxService.queryList(query);
		int total = webchatMessageboxService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(webchatMessageboxList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("webchatmessagebox:info")
	public R info(@PathVariable("id") Integer id){
		WebchatMessageboxEntity webchatMessagebox = webchatMessageboxService.queryObject(id);
		
		return R.ok().put("webchatMessagebox", webchatMessagebox);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("webchatmessagebox:save")
	public R save(@RequestBody WebchatMessageboxEntity webchatMessagebox){
		webchatMessageboxService.save(webchatMessagebox);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("webchatmessagebox:update")
	public R update(@RequestBody WebchatMessageboxEntity webchatMessagebox){
		webchatMessageboxService.update(webchatMessagebox);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("webchatmessagebox:delete")
	public R delete(@RequestBody Integer[] ids){
		webchatMessageboxService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
