package com.zw.zwshop.dto;
/**
 * 
 * @ClassName:  CategoryDto   
 * @Description: 分类的查询条件 
 * @author: LiuJinrong
 * @date:   2019年1月8日 下午2:59:52
 */
public class CategoryDto {
	
	/**
	 * 当前页
	 */
	private int page = 1;
	/**
	 * 页容量
	 */
	private int limit = 10;
	/**
	 * 分类名称
	 */
	private String cateName;
	/**
	 * 父分类id
	 * -1 代表查询全部
	 */
	private int pId = -1;
	
	
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
