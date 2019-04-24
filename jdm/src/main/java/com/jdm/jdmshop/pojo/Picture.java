package com.jdm.jdmshop.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  Picture   
 * @Description: 图片存储路径实体类 
 * @author: LiuJinrong
 * @date:   2019年2月10日 上午1:27:35
 */
@Table(name="picture")
public class Picture {
	
	/**
	 * 图片id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pid;
	
	/**
	 * 图片路径
	 */
	private String ppath;
	
	/**
	 * 图片名称
	 */
	private String pname;
	
	/**
	 * 图片类型
	 */
	private String ptype;
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPpath() {
		return ppath;
	}

	public void setPpath(String ppath) {
		this.ppath = ppath;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
}
