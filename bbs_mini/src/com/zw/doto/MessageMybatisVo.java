package com.zw.doto;

import java.util.List;

import com.zw.pojo.CountMsg;
import com.zw.pojo.Message;

/**
 * 
 * 类描述：添加主题一对多实体类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月19日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
// 一表
public class MessageMybatisVo extends Message {
	// 多表
	private List<CountMsg> countmsgs;

	public MessageMybatisVo() {
		
	}

	public MessageMybatisVo(List<CountMsg> countmsgs) {
		this.countmsgs = countmsgs;
	}

	public List<CountMsg> getCountmsgs() {
		return countmsgs;
	}

	public void setCountmsgs(List<CountMsg> countmsgs) {
		this.countmsgs = countmsgs;
	}

}
