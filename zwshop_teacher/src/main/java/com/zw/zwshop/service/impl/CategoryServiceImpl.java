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

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public int add(Category category) {
		category.setCreateTime(ToolUtil.getCurrentTime());
		if(category.getpId()==0){
			category.setLevel(SysUtil.LEVEL_FIRST);//级别  一级分类
		}else {
			category.setLevel(SysUtil.LEVEL_SECOND);//级别  二级分类
		}
		category.setDisabled(SysUtil.DISABLED_NOT);
		return categoryMapper.insertSelective(category);
	}

	@Override
	public List<Category> selectF() {
		Category category = new Category();
		category.setLevel(SysUtil.LEVEL_FIRST);
		category.setDisabled(SysUtil.DISABLED_NOT);
		return categoryMapper.select(category);
	}

	@Override
	public PageInfo list(CategoryDto categoryDto) {
		PageHelper.startPage(categoryDto.getPage(), categoryDto.getLimit());
		List<CategoryVo> list = categoryMapper.selectPage(categoryDto);
		PageInfo<CategoryVo> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	
	
}
