package com.zw.zwshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zw.zwshop.dto.CategoryDto;
import com.zw.zwshop.pojo.Category;
import com.zw.zwshop.service.CategoryService;
import com.zw.zwshop.utils.R;

/**   
 * @ClassName:  CategoryController   
 * @Description:TODO 分类的处理器
 * @author: lilong
 * @date:   2019年1月8日 上午10:23:29       
 */  
@Controller
@RequestMapping(value="category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	/**     
	 * @Description:TODO 新增
	 * @author: lilong
	 * @date:   2019年1月8日 上午10:31:28    
	 * @return      
	 */  
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public R add(Category category){
		try {
			categoryService.add(category);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return R.ok();
	}
	
	
	/**     
	 * @Description:TODO 查询一级分类列表
	 * @author: lilong 
	 * @date:   2019年1月8日 上午11:35:25    
	 * @return      
	 */ 
	@RequestMapping(value="selectF",method=RequestMethod.POST)
	@ResponseBody
	public R selectF(){
		List<Category> categorys = null;
		try {
			categorys = categoryService.selectF();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return R.ok().put("categorys", categorys); 
	}
	
	/**     
	 * @Description:TODO 条件+分页查询 分类列表
	 * @author: lilong
	 * @date:   2019年1月8日 下午2:57:08    
	 * @return      
	 */  
	@RequestMapping(value="list",method=RequestMethod.POST)
	@ResponseBody
	public R list(CategoryDto categoryDto){
		PageInfo pageInfo = null;
		try {
			pageInfo = categoryService.list(categoryDto);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
		return R.ok().put("page", pageInfo);
	}

}
