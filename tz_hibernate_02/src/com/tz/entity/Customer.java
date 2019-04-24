package com.tz.entity;
/**
 * 
 * 类描述：orm元数据实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月5日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */

/**
 * 
 * CREATE TABLE `cst_customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_source` varchar(255) DEFAULT NULL,
  `cust_industry` varchar(255) DEFAULT NULL,
  `cust_level` varchar(255) DEFAULT NULL,
  `cust_linkman` varchar(255) DEFAULT NULL,
  `cust_phone` varchar(255) DEFAULT NULL,
  `cust_moblie` varchar(255) DEFAULT NULL,
 * 
 */
public class Customer {
	private  Long cust_id;
	private  String cust_name;
	private  String cust_source;
	private  String cust_industry;
	private  String cust_level;
	private  String cust_linkman;
	private  String cust_phone;
	private  String cust_moblie;
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_moblie() {
		return cust_moblie;
	}
	public void setCust_moblie(String cust_moblie) {
		this.cust_moblie = cust_moblie;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_source=" + cust_source
				+ ", cust_industry=" + cust_industry + ", cust_level=" + cust_level + ", cust_linkman=" + cust_linkman
				+ ", cust_phone=" + cust_phone + ", cust_moblie=" + cust_moblie + "]";
	}
}
