package com.zw.zw_repertory.controller;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 类描述：LayuiForm表单测试类
 * 作者： LiuJinrong  
 * 创建日期：2019年1月2日
 * 修改人：
 * 修改日期：
 * 修改内容：
 * 版本号： 1.0.0
 */
@Controller
@RequestMapping("layuiForm")
public class LayuiFormTest {
	
	@RequestMapping("test")
	@ResponseBody
	public Map test(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		// 遍历
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			// key值
			Object strKey = element.getKey();
			// value,数组形式
			String[] value = (String[]) element.getValue();

			System.out.print(strKey.toString() + "=");
			for (int i = 0; i < value.length; i++) {
				System.out.print(value[i] + ",");
			}
			System.out.println();
		}
		return map;

	}

}




