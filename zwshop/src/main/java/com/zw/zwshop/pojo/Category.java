package com.zw.zwshop.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  Category   
 * @Description:分类表实体类
 * @author: LiuJinrong
 * @date:   2019年1月5日 下午2:18:24
 */

// 设置通用mapper
@Table(name="category")
public class Category {
	
	// 主键ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cateId;
	// 分类的名字
	private String cateName;
	// 上级分类id, 一级分类的父id为0
	private Integer pId;
	// 级别
	private Integer level;
	// 创建时间
	private String createTime;
	// 是否禁用,0:未禁用（默认值为0）,1:禁用
	private Integer disabled;
	
	
	public Integer getCateId() {
		return cateId;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disable) {
		this.disabled = disable;
	}

}
