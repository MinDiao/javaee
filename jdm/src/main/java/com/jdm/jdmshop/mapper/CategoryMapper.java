package com.jdm.jdmshop.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.jdm.jdmshop.dto.CategoryDto;
import com.jdm.jdmshop.dto.CategoryVo;
import com.jdm.jdmshop.pojo.Category;

/**
 * 
 * @ClassName:  CategoryMapper   
 * @Description: 商品种类Mapper接口
 * @author: LiuJinrong
 * @date:   2019年2月11日 下午11:34:07
 */
public interface CategoryMapper extends Mapper<Category> {
	
	
	/**
	 * 
	 * @Description: 条件+分页查询分类列表
	 * @author: LiuJinrong
	 * @date:   2019年2月13日 下午3:00:48    
	 * @param categoryDto
	 * @return
	 */
	List<CategoryVo> selectPage(CategoryDto categoryDto);

}






