package com.zw.zw_repertory.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.zw_repertory.dto.RepertoryDto;
import com.zw.zw_repertory.mapper.RepertoryMapper;
import com.zw.zw_repertory.pojo.RepertoryCount;
import com.zw.zw_repertory.pojo.RepertoryList;
import com.zw.zw_repertory.service.RepertoryService;

/**
 * 
 * 类描述：库存业务逻辑层实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Service
public class RepertoryServiceImpl implements RepertoryService {
	
	// 注入库存mapper
	@Autowired
	private RepertoryMapper repertoryMapper;

	/**
	 *  库存列表+模糊查询+分页
	 */
	@Override
	public PageInfo repertorySelect(RepertoryDto repertoryDto) {
		
		// 通用mapper分页拦截器
		PageHelper.startPage(repertoryDto.getPageNum(), repertoryDto.getPageSize());
		
		// 执行库存持久化层查询方法
		List<RepertoryList> repertorys = repertoryMapper.repertorySelect(repertoryDto);
		
		// 对Page结果进行包装
		PageInfo<RepertoryList> pageInfo = new PageInfo<>(repertorys);
		
		return pageInfo;
	}

	
	
	/**
	 * 添加商品
	 */
	
	// 开启事务注解
	@Transactional
	@Override
	public int repertoryAdd(RepertoryCount repertoryCount) throws RuntimeException {
		
		// 执行添加商品方法
		repertoryMapper.repertoryAdd(repertoryCount);
		
		// 测试事务
		// int a = 1 / 0;
		
		// 封装到对象
		RepertoryCount rc = new RepertoryCount();
		// 获取mybatis添加后返回的主键自增的id值
		rc.setShopId(repertoryCount.getShopId());
		rc.setCountNumber(repertoryCount.getCountNumber());
		
		// 执行添加对应商品id的库存
		return repertoryMapper.repertoryAddCount(rc);
	}

}

















