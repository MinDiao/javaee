package com.zw.zwshop.pojo;
/**
 * 
 * @ClassName:  Cart   
 * @Description:Description
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午2:17:45
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
