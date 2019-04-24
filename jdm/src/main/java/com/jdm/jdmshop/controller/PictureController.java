package com.jdm.jdmshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdm.jdmshop.pojo.Picture;
import com.jdm.jdmshop.service.PictureService;
import com.jdm.jdmshop.utils.R;

/**
 * 
 * @ClassName:  PictureController   
 * @Description: 图片路径控制层 
 * @author: LiuJinrong
 * @date:   2019年2月10日 上午11:28:01
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
	
	/**
	 * 注入Servier
	 */
	@Autowired
	private PictureService pictureService;
	
	
	/**
	 * 
	 * @Description: 按图片类型查询图片路径
	 * @author: LiuJinrong
	 * @date:   2019年2月10日 上午11:33:54    
	 * @param picture
	 * @return
	 */
	@RequestMapping("select")
	@ResponseBody
	public R select(Picture picture){
		
		// 创建填充图片路径对象的List集合
		List<Picture> pictures = null;
		
		try {
			// 调用业务逻辑层查询图片路径方法
			pictures = pictureService.Select(picture);
			
		} catch (Exception e) {
			// 抛出异常
			e.printStackTrace();
			// 错误信息响应至页面
			return R.error("服务器发生未知异常,请联系管理员");
		}
		
		// 判断是否查询成功
		if (pictures != null) {
			// 查询成功
			return R.ok().put("pictures", pictures);
			
		} else {
			// 不存在
			return R.error("图片不存在");
		}
		
	}
	
	
	
	
	

}








