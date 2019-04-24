package com.zw.zw_repertory.dto;

import com.zw.zw_repertory.pojo.RepertoryList;

/**
 * 
 * 类描述：springtask任务调度实体类
 * 作者： LiuJinrong  
 * 创建日期：2019年1月1日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public class DateCronDto extends RepertoryList {
	// 现在时间
	private String nowDate;

	public DateCronDto() {
		
	}

	public String getNowDate() {
		return nowDate;
	}

	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	
}
