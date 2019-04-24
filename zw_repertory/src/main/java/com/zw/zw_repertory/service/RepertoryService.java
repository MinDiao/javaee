package com.zw.zw_repertory.service;

import com.github.pagehelper.PageInfo;
import com.zw.zw_repertory.dto.RepertoryDto;
import com.zw.zw_repertory.pojo.RepertoryCount;

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
	 * 方法描述: 添加商品
	 * @param repertoryList 填充商品实体类的List集合
	 * @return 影响行数
	 */
	int repertoryAdd(RepertoryCount repertoryCount) throws RuntimeException;

}
