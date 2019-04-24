package com.zw.zwshop.pojo;
/**
 * 
 * 类描述：购物车表实体类
 * 作者：   
 * 创建日期：2019年1月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class Cart {
	
	// 主键ID
	private Integer cartId;
	// 会员
	private Integer memberId;
	// 商品
	private Integer itemId;
	// 数量
	private Integer number;
	
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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
	
}
