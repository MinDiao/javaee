package com.zw.zwshop.pojo;
/**
 * 
 * @ClassName:  OrderItem   
 * @Description:子订单表实体类
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午2:18:54
 */
public class OrderItem {

	// 主键ID
	private Integer orderItemId;
	// 主订单ID
	private Integer orderId;
	// 商品
	private Integer itemId;
	// 数量
	private Integer number;
	// 价格, 是乘以数量后的价格
	private String price;
	
	
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
