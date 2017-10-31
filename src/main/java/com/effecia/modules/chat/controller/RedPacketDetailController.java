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

import com.effecia.modules.chat.entity.RedPacketDetailEntity;
import com.effecia.modules.chat.service.RedPacketDetailService;
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
@RequestMapping("redpacketdetail")
public class RedPacketDetailController {
	@Autowired
	private RedPacketDetailService redPacketDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("redpacketdetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RedPacketDetailEntity> redPacketDetailList = redPacketDetailService.queryList(query);
		int total = redPacketDetailService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(redPacketDetailList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{rid}")
	@RequiresPermissions("redpacketdetail:info")
	public R info(@PathVariable("rid") Integer rid){
		RedPacketDetailEntity redPacketDetail = redPacketDetailService.queryObject(rid);
		
		return R.ok().put("redPacketDetail", redPacketDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("redpacketdetail:save")
	public R save(@RequestBody RedPacketDetailEntity redPacketDetail){
		redPacketDetailService.save(redPacketDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("redpacketdetail:update")
	public R update(@RequestBody RedPacketDetailEntity redPacketDetail){
		redPacketDetailService.update(redPacketDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("redpacketdetail:delete")
	public R delete(@RequestBody Integer[] rids){
		redPacketDetailService.deleteBatch(rids);
		
		return R.ok();
	}
	
}
