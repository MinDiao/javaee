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
 * 
 * @ClassName:  CategoryController   
 * @Description: 分类的处理器 
 * @author: LiuJinrong
 * @date:   2019年1月8日 上午10:23:56
 */

@Controller
@RequestMapping("category")
public class CategoryController {
	
	
	/**
	 * 注入Mapper
	 */
	@Autowired
	private CategoryService categoryService;
	
	
	
	/**
	 * 
	 * @Description: 新增
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 上午10:32:35    
	 * @return
	 */
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public R add(Category category){
		
		try {
			// 调用新增方法
			categoryService.add(category);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常
			return R.error();
		}
		
		
		
		// 响应
		return R.ok();
	}
	
	
	
	
	/**
	 * 
	 * @Description: 查询一级分类列表
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 上午11:35:46
	 */
	@RequestMapping(value="selectF", method=RequestMethod.POST)
	@ResponseBody
	public R selectF(){
		
		// 创建填充Category对象的list集合
		List<Category> categories = null;
		
		try {
			// 执行查询方法
			categories = categoryService.select();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 响应
		return R.ok().put("categorys", categories);
	}
	
	
	
	
	
	/**
	 * 
	 * @Description: 条件+分页查询分类列表
	 * @author: LiuJinrong
	 * @date:   2019年1月8日 下午2:57:36    
	 * @return
	 */
	@RequestMapping(value="list", method=RequestMethod.POST)
	@ResponseBody
	public R list(CategoryDto categoryDto){
		
		// 
		PageInfo pageInfo = null;
		
		try {
			// 执行条件+分页查询分类列表方法
			pageInfo = categoryService.list(categoryDto);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常
			return R.error();
		}
		
		// 响应至页面
		return R.ok().put("page", pageInfo);
		
	}
	
	
	
	
	/**
	 * 
	 * @Description: 执行禁用单条商品信息方法
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午1:17:23    
	 * @param cateId
	 * @return
	 */
	@RequestMapping(value="off", method=RequestMethod.POST)
	@ResponseBody
	public R off(String cateId){
		
		try {
			// 执行禁用单条商品信息方法
			categoryService.off(cateId);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常
			R.error();
		}
		
		// 响应至ajax
		return R.ok();
	}
	
	
	
	
	
	/**
	 * 
	 * @Description: 批量禁用单条商品信息
	 * @author: LiuJinrong
	 * @date:   2019年1月9日 上午1:22:37    
	 * @param cateIds
	 * @return
	 */
	@RequestMapping(value="offs", method=RequestMethod.POST)
	@ResponseBody
	public R offs(String[] cateIds){
		
		try {
			// 执行批量禁用单条商品信息方法
			categoryService.offs(cateIds);
			
		} catch (Exception e) {
			e.printStackTrace();
			// 抛出异常
			R.error();
		}
		
		// 响应至ajax
		return R.ok();
	}
	

}














