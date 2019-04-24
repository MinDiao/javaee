package com.zw.zwshop.dto;

import com.zw.zwshop.pojo.Category;

/**   
 * @ClassName:  CategoryVo   
 * @Description:TODO 分类信息展示
 * @author: lilong
 * @date:   2019年1月8日 下午2:43:32       
 */  
public class CategoryVo extends Category{

	private String pCateName;//上级分类名称

	public String getpCateName() {
		return pCateName;
	}

	public void setpCateName(String pCateName) {
		this.pCateName = pCateName;
	}
	
	
}
