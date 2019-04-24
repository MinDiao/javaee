package com.jdm.jdmshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jdm.jdmshop.dto.CategoryDto;
import com.jdm.jdmshop.dto.CategoryVo;
import com.jdm.jdmshop.pojo.Category;

/**
 * 
 * @ClassName:  CategoryService   
 * @Description: 商品种类业务逻辑层接口
 * @author: LiuJinrong
 * @date:   2019年2月11日 下午11:28:08
 */
public interface CategoryService {

	
	/**
	 * 
	 * @Description: 查询商品一级类
	 * @author: LiuJinrong
	 * @date:   2019年2月11日 下午11:28:56    
	 * @param category
	 * @return
	 */
	List<Category> select(Category category);
	
	
	
	/**
	 * 
	 * @Description: 条件+分页查询分类列表
	 * @author: LiuJinrong
	 * @date:   2019年2月13日 下午3:10:22    
	 * @param categoryDto
	 * @return
	 */
	PageInfo list(CategoryDto categoryDto);

}






