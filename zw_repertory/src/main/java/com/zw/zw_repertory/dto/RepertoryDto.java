package com.zw.zw_repertory.dto;

import java.util.Date;

/**
 * 
 * 类描述：库存列表扩展实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class RepertoryDto {
	// 商品名称
	private String listName;
	// 商品价格前区间
	private Double listBeginPrice;
	// 商品价格后区间
	private Double listEndPrice;
	// 商品状态
	private Integer listStatus;
	// 商品贩卖开始时间
	private String listBegindate;
	// 商品贩卖结束时间
	private String listEnddate;
	
	// 页码
	private int pageNum;
	// 页容量
	private int pageSize;
	
	
	public RepertoryDto() {
		
	}
	
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Double getListBeginPrice() {
		return listBeginPrice;
	}
	public void setListBeginPrice(Double listBeginPrice) {
		this.listBeginPrice = listBeginPrice;
	}
	public Double getListEndPrice() {
		return listEndPrice;
	}
	public void setListEndPrice(Double listEndPrice) {
		this.listEndPrice = listEndPrice;
	}
	public Integer getListStatus() {
		return listStatus;
	}
	public void setListStatus(Integer listStatus) {
		this.listStatus = listStatus;
	}
	public String getListBegindate() {
		return listBegindate;
	}
	public void setListBegindate(String listBegindate) {
		this.listBegindate = listBegindate;
	}
	public String getListEnddate() {
		return listEnddate;
	}
	public void setListEnddate(String listEnddate) {
		this.listEnddate = listEnddate;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}






