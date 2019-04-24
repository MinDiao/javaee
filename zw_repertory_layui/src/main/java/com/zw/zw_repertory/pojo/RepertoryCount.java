package com.zw.zw_repertory.pojo;

/**
 * 
 * 类描述：库存数量实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
// @Table(name="repertory_count")
public class RepertoryCount extends RepertoryList {
	// 商品ID
	// @Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shopId;
	// 库存数量
	private Integer countNumber;
	
	public RepertoryCount() {
		
	}
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getCountNumber() {
		return countNumber;
	}
	public void setCountNumber(Integer countNumber) {
		this.countNumber = countNumber;
	}
}
