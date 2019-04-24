package com.zw.zw_repertory.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 类描述：库存列表实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Table(name="repertory_list")
public class RepertoryList {
	
	// 商品ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shopId;
	// 商品名称
	private String listName;
	// 商品代码
	private String listCode;
	// 商品价格
	private Double listPrice;
	// 商品状态
	private Integer listStatus;
	// 商品贩卖开始时间
	private String listBegindate;
	// 商品贩卖结束时间
	private String listEnddate;
	
	// 级联一对一库存数量
	private RepertoryCount repertoryCount;
	
	
	public RepertoryList() {
		
	}
	
	public RepertoryCount getRepertoryCount() {
		return repertoryCount;
	}
	public void setRepertoryCount(RepertoryCount repertoryCount) {
		this.repertoryCount = repertoryCount;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public String getListCode() {
		return listCode;
	}
	public void setListCode(String listCode) {
		this.listCode = listCode;
	}
	public Double getListPrice() {
		return listPrice;
	}
	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
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
}
