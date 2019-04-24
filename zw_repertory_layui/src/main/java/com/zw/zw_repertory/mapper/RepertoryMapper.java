package com.zw.zw_repertory.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.zw_repertory.dto.DateCronDto;
import com.zw.zw_repertory.dto.RepertoryDto;
import com.zw.zw_repertory.pojo.RepertoryList;


/**
 * 
 * 类描述：库存持久化层mapper接口
 * 作者： LiuJinrong  
 * 创建日期：2018年12月31日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
public interface RepertoryMapper extends Mapper<RepertoryList> {

	/**
	 * 
	 * 方法描述: 库存列表+模糊查询+分页
	 * @param repertoryDto 库存列表扩展实体类
	 * @return 填充库存列表对象的list集合
	 */
	List<RepertoryList> repertorySelect(RepertoryDto repertoryDto);
	
	
	
	
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
	 * @param repertoryList
	 * @return
	 */
	int repertoryAdd(RepertoryList repertoryList);
	
	
	/**
	 * 
	 * 方法描述: 添加对应商品id的库存
	 * @param repertoryList
	 * @return
	 */
	int repertoryAddCount(RepertoryList repertoryList);
	
	
	
	/**
	 * 
	 * 方法描述: 查询商品贩卖结束时间小于当前时间的商品id
	 * @param dateCron 当前时间
	 * @return 符合的商品id
	 */
	List<DateCronDto> selectDateCron(DateCronDto dateCronDto);
	
	
	
	/**
	 * 
	 * 方法描述: 修改商品贩卖结束时间小于当前时间的商品id
	 * @param updateCrons 商品id数组
	 * @return 影响行数
	 */
	int updateDateCron(List<Integer> updateCrons);



	/**
	 * 
	 * 方法描述: 删除单个商品+批量删除商品
	 * @param shopId 填充商品id的数组
	 * @return 影响行数
	 */
	int repertoryDeleteByIds(Integer shopId);



	
	/**
	 * 
	 * 方法描述: 根据id数组批量删除商品
	 * @param shopIds 填充商品ids的数组
	 * @return 影响行数
	 */
	int repertoryDeleteByIds(String[] shopIds);

	
	

}






