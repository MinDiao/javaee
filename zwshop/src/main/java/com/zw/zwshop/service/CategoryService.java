package com.zw.zwshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.CategoryDto;
import com.zw.zwshop.pojo.Category;

/**
 * 
 * @ClassName:  CategoryService   
 * @Description: 分类服务接口
 * @author: LiuJinrong
 * @date:   2019年1月8日 上午10:29:00
 */
public interface CategoryService {

	
	
	/**
	 * 
	 * @Description: 新增
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 上午10:34:07    
	 * @param category
	 * @return 
	 */
	int add(Category category);

	
	
	
	/**
	 * 
	 * @Description: 查询一级分类
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 上午11:38:56    
	 * @return
	 */
	List<Category> select();




	
	/**
	 * 
	 * @Description: 条件+分页查询分类列表
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 下午3:19:17    
	 * @return
	 */
	PageInfo list(CategoryDto categoryDto);



	

	/**
	 * 
	 * @Description: 执行禁用单条商品信息方法
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午1:22:56    
	 * @param cateId
	 * @return 
	 */
	int off(String cateId);




	
	/**
	 * 
	 * @Description: 批量禁用单条商品信息
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午1:25:25    
	 * @param cateIds
	 * @return 
	 */
	int offs(String[] cateIds);




}












