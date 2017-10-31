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

import com.effecia.modules.chat.entity.RedPacketEntity;
import com.effecia.modules.chat.service.RedPacketService;
import com.effecia.common.utils.PageUtils;
import com.effecia.common.utils.Query;
import com.effecia.common.utils.R;


/**
 * 
 * 
 * @author lin
 * @email lin.lin@support888.net
 * @date 2017-10-31 16:40:37
 */
@RestController
@RequestMapping("redpacket")
public class RedPacketController {
	@Autowired
	private RedPacketService redPacketService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("redpacket:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RedPacketEntity> redPacketList = redPacketService.queryList(query);
		int total = redPacketService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(redPacketList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("redpacket:info")
	public R info(@PathVariable("id") Integer id){
		RedPacketEntity redPacket = redPacketService.queryObject(id);
		
		return R.ok().put("redPacket", redPacket);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("redpacket:save")
	public R save(@RequestBody RedPacketEntity redPacket){
		redPacketService.save(redPacket);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("redpacket:update")
	public R update(@RequestBody RedPacketEntity redPacket){
		redPacketService.update(redPacket);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("redpacket:delete")
	public R delete(@RequestBody Integer[] ids){
		redPacketService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
