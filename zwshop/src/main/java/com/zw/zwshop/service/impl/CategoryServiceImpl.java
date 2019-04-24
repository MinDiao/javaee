package com.zw.zwshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.CategoryDto;
import com.zw.zwshop.dto.CategoryVo;
import com.zw.zwshop.mapper.CategoryMapper;
import com.zw.zwshop.pojo.Category;
import com.zw.zwshop.service.CategoryService;
import com.zw.zwshop.utils.SysUtil;
import com.zw.zwshop.utils.ToolUtil;

/**
 * 
 * @ClassName:  CategoryServiceImpl   
 * @Description: 分类服务实现类 
 * @author: LiuJinrong
 * @date:   2019年1月8日 上午10:29:25
 */

@Service
public class CategoryServiceImpl implements CategoryService {
	
	
	/**
	 * 注入Mapper
	 */
	@Autowired
	private CategoryMapper categoryMapper;

	
	
	/**
	 * 新增
	 * @return 
	 */
	@Override
	public int add(Category category) {
		
		// 设置对象时间
		category.setCreateTime(ToolUtil.getCurrentTime());
		
		// 判断级别
		if (category.getpId() == 0) {
			// 1级分类
			category.setLevel(1);
		} else {
			// 2级分类
			category.setLevel(2);
		}
		
		// 方法1: 依赖数据库默认设置disable为0未禁用则不需要手动设置
		// 方法2: 自定义常量类,设置对象
		
		category.setDisabled(SysUtil.DISABLED_NOT);
		
		// 调用通用mapper的选择性新增
		return categoryMapper.insertSelective(category);
	}



	
	
	/**
	 * 查询一级分类
	 */
	@Override
	public List<Category> select() {
		
		// 初始化对象
		Category category = new Category();
		category.setLevel(SysUtil.LEVEL_FIRST);
		category.setDisabled(SysUtil.DISABLED_NOT);
		
		return categoryMapper.select(category);
	}





	/**
	 * 条件+分页查询分类列表
	 */
	@Override
	public PageInfo list(CategoryDto categoryDto) {
		
		PageHelper.startPage(categoryDto.getPage(), categoryDto.getLimit());
		
		List<CategoryVo> list = categoryMapper.selectPage(categoryDto);
		
		PageInfo<CategoryVo> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}





	/**
	 * 禁用单条商品信息
	 */
	@Override
	public int off(String cateId) {
		
		return categoryMapper.off();
	}





	/**
	 * 批量禁用单条商品信息
	 */
	@Override
	public int offs(String[] cateIds) {
		
		return categoryMapper.offs();
	}

}

















