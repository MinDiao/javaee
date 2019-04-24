package com.zw.zwshop.dto;

/**
 * @ClassName: CategoryDto
 * @Description:TODO 分类的查询条件
 * @author: lilong
 * @date: 2019年1月8日 下午2:59:49
 */
public class CategoryDto {

	private int page = 1;// 当前页

	private int limit = 10;// 页容量
	
	private String cateName;//分类名称
	
	private int pId = -1;//父分类id

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
	
}
