package com.zw.zwshop.pojo;
/**
 * 
 * @ClassName:  OrderMaster   
 * @Description:主订单表实体类
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午2:19:03
 */
public class OrderMaster {

	// 主键ID
	private Integer orderId;
	// 流水号
	private String orderSn;
	// 购买人, 对应会员表的主键id
	private Integer memberId;
	// 金额
	private String payment;
	// 状态,10:未付款（默认）,20:已付款,30:已发货,40:确认收货,50:已评价
	private Integer status;
	// 创建时间
	private String createTime;
	// 付款时间
	private String payTime;
	// 发货时间
	private String deliveryTime;
	// 收货信息, 额外的创建一个收货地址的表。Id 。。。, 修改、 济宁——济南
	private String deliveryInfo;
	// 是否禁用,0:未禁用（默认值为0）,1:禁用
	private Integer disabled;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	
}
