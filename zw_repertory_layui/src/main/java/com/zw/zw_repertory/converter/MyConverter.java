package com.zw.zw_repertory.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @ClassName:  MyConverter   
 * @Description: TODO 
 * @author: LiuJinrong
 * @date:   2019年1月13日 上午8:15:31
 */
public class MyConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		
		try {
			Date date = simpleDateFormat.parse(source);
			return date;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
