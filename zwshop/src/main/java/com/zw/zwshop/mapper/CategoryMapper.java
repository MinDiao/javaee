package com.zw.zwshop.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.zwshop.dto.CategoryDto;
import com.zw.zwshop.dto.CategoryVo;
import com.zw.zwshop.pojo.Category;

/**
 * 
 * @ClassName:  CategoryMapper   
 * @Description: 分类的mapper接口 
 * @author: LiuJinrong
 * @date:   2019年1月8日 上午10:28:31
 */
public interface CategoryMapper extends Mapper<Category> {

	
	
	/**
	 * 
	 * @Description: 条件+分页查询分类列表
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 下午3:22:20    
	 * @param categoryDto
	 * @return
	 */
	List<CategoryVo> selectPage(CategoryDto categoryDto);

	
	
	
	
	/**
	 * 
	 * @Description: 禁用单条商品信息
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午1:23:45    
	 * @return
	 */
	int off();




	/**
	 * 
	 * @Description: 批量禁用单条商品信息
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午1:26:08    
	 * @return
	 */
	int offs();
	
	

}




