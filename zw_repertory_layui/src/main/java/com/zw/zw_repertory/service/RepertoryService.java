package com.zw.zw_repertory.service;

import com.github.pagehelper.PageInfo;
import com.zw.zw_repertory.dto.RepertoryDto;
import com.zw.zw_repertory.pojo.RepertoryCount;
import com.zw.zw_repertory.pojo.RepertoryList;

/**
 * 
 * 接口描述：库存业务逻辑层接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface RepertoryService {

	/**
	 * 
	 * 方法描述: 库存列表+模糊查询+分页
	 * @return 填充库存列表实体类对象的page结果集
	 */
	PageInfo<RepertoryDto> repertorySelect(RepertoryDto repertoryDto);
	

	
	/**
	 * 
	 * @Description: 根据商品id查询数据用于回显
	 * @author: LiuJinrong
	 * @date:   2019年1月6日 上午1:49:29    
	 * @param shopId 商品id
	 * @return RepertoryList对象
	 */
	RepertoryList repertorySelectById(String shopId);

	
	
	/**
	 * 
	 * 方法描述: 添加商品
	 * @param repertoryList 填充商品实体类的List集合
	 * @return 影响行数
	 */
	int repertoryAdd(RepertoryCount repertoryCount) throws RuntimeException;


	
	/**
	 * 
	 * 方法描述: 删除单个商品
	 * @param shopId 商品id
	 * @return 影响行数
	 */
	int repertoryDeleteById(Integer shopId);



	
	/**
	 * 
	 * 方法描述: 根据id数组批量删除商品
	 * @param shopIds 填充商品ids的数组
	 * @return 影响行数
	 */
	int repertoryDeleteByIds(String[] shopIds);



	
	/**
	 * 
	 * @Description: 修改商品信息
	 * @author: LiuJinrong 
	 * @date:   2019年1月6日 下午3:25:00    
	 * @param repertoryCount 商品信息对象
	 * @return 影响行数
	 */
	int repertoryUpdate(RepertoryCount repertoryCount);


	

}










