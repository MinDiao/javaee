package com.zw.zwshop.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.zw.zwshop.dto.SysUserDto;
import com.zw.zwshop.pojo.SysUser;

/**   
 * @ClassName:  SysUserMapper   
 * @Description:TODO 管理员mapper
 * @author: lilong
 * @date:   2019年1月5日 下午4:41:55       
 */  
public interface SysUserMapper extends Mapper<SysUser>{

	
	/**     
	 * @Description:TODO 条件查询列表
	 * @author: lilong
	 * @date:   2019年1月7日 上午10:46:51    
	 * @param sysUserDto
	 * @return      
	 */  
	List<SysUser> selectPage(SysUserDto sysUserDto);

	/**     
	 * @Description:TODO 批量删除
	 * @author: lilong
	 * @date:   2019年1月7日 下午2:21:45    
	 * @param ids
	 * @return      
	 */  
	int deleteBatch(String[] ids);
}
