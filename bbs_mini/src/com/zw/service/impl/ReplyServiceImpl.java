package com.zw.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zw.dao.ReplyDao;
import com.zw.dao.impl.ReplyDaoImpl;
import com.zw.doto.ReplyVo;
import com.zw.pojo.Reply;
import com.zw.service.ReplyService;
import com.zw.util.JdbcUtils;
/**
 * 
 * 类描述：回帖实现类
 * 作者： LiuJinrong  
 * 创建日期：2018年12月26日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	/**
	 * 回帖显示
	 */
	@Override
	public List<ReplyVo> select(String msgid) {
		
		return replyDao.select(msgid);
	}

	/**
	 * 回帖
	 */
	@Override
	@Transactional
	public int addReply(Reply reply) throws RuntimeException {
		int result = 0;
		try {
			// 开启事务
			JdbcUtils.beginTransaction();
			
			// 回帖
			result += replyDao.addReplyContents(reply);
			
			// 回帖数量+1
			result += replyDao.addReplyCount(reply);
			
			// 提交事务
			JdbcUtils.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				// 回滚事务
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}


}
