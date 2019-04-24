package com.zw.zwshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.CategoryDto;
import com.zw.zwshop.pojo.Category;

/**   
 * @ClassName:  CategoryService   
 * @Description:TODO 分类服务
 * @author: lilong
 * @date:   2019年1月8日 上午10:28:42       
 */  
public interface CategoryService {

	/**     
	 * @Description:TODO 新增
	 * @author: lilong
	 * @date:   2019年1月8日 上午10:34:13    
	 * @param category
	 * @return      
	 */  
	int add(Category category);

	/**     
	 * @Description:TODO 查询一级分类
	 * @author: lilong
	 * @date:   2019年1月8日 上午11:38:51    
	 * @return      
	 */  
	List<Category> selectF();

	/**     
	 * @Description:TODO 条件+ 分页
	 * @author: lilong
	 * @param categoryDto 
	 * @date:   2019年1月8日 下午2:59:06    
	 * @return      
	 */  
	PageInfo list(CategoryDto categoryDto);

}
