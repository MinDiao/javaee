package com.zw.mapper;

import java.util.List;

import com.zw.doto.MessageMybatisVo;
import com.zw.pojo.Message;
import com.zw.pojo.User;

/**
 * 
 * 接口描述：mapper映射文件接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月19日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface UserMapper {

	/**
	 * 
	 * 方法描述: 用户登录
	 * @param user 用户对象
	 * @return 用户实体类
	 */
	public User login(User user);
	
	
	/**
	 * TODO
	 * 方法描述: 添加主题
	 * @param msg
	 * @return
	 */
	//public int addMessage(Message msg);
	
	
	/**
	 * 
	 * 方法描述: 首页帖子列表
	 * @param msgmbvo
	 * @return
	 */
	List<MessageMybatisVo> messageList();
	
}
