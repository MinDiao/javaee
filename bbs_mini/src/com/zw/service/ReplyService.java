package com.zw.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.doto.ReplyVo;
import com.zw.pojo.Reply;
/**
 * 
 * 接口描述：回帖接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月26日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface ReplyService {

	/**
	 * 
	 * 方法描述:回帖显示
	 * @param msgid
	 * @return
	 */
	List<ReplyVo> select(String msgid);

	/**
	 * 
	 * 方法描述:回帖
	 * @param reply 回帖对象
	 * @return 影响行数
	 * @throws SQLException 
	 */
	int addReply(Reply reply) throws RuntimeException;

}
