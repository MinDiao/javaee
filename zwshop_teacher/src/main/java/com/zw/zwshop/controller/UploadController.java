package com.zw.zwshop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zw.zwshop.utils.PropertiesUtil;
import com.zw.zwshop.utils.R;

/**   
 * @ClassName:  UploadController   
 * @Description:TODO 文件上传下载、查询、视频
 * @author: lilong
 * @date:   2019年1月9日 上午11:49:53       
 */  
@Controller
@RequestMapping("file")
public class UploadController {

	private static final String path = PropertiesUtil.getProperties_1("config.properties", "config.path");// 文件保存路径

	private static final String basePath = PropertiesUtil.getProperties_1("config.properties", "config.basePath");// 项目路径

	/**
	 * 文件上传
	 */
	@RequestMapping(value = "/fileUpload")
	@ResponseBody
	public R fileUpload(@RequestParam("file") MultipartFile file) {
		String new_filename = "";
		try {
			// 获取上传文件的原始名称
			String org_filename = file.getOriginalFilename();
			String suffix = org_filename.substring(org_filename.lastIndexOf("."));//文件的后缀  .png
			// 设置上传文件的保存目录
			File filePath = new File(path);
			// 如果保存文件的地址不存在，就先创建目录
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			// 使用UUID进行重命名
			new_filename = UUID.randomUUID() + suffix;
			//System.err.println(new_filename);
			// 使用MultipartFile 接口的方法 完成上传到指定位置
			file.transferTo(new File(path + "/" + new_filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return R.ok().put("path", basePath + "file/show?filename=" + new_filename);
	}

	/**
	 * 图片查询
	 */
	@RequestMapping(value = "/show")
	public void showImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("image/jpeg");
		String fname = request.getParameter("filename");
		String newpath = new String(fname.getBytes("ISO-8859-1"), "UTF-8");
		String absolutePath = path + newpath;
		FileInputStream fis = new FileInputStream(absolutePath);
		OutputStream os = response.getOutputStream();
		try {
			int count = 0;
			byte[] buffer = new byte[1024 * 1024];
			while ((count = fis.read(buffer)) != -1)
				os.write(buffer, 0, count);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				os.close();
			if (fis != null)
				fis.close();
		}
	}

	/**
	 * 文件下载
	 */
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request, String filename) throws Exception {
		// 指定要下载的文件所在路径
		// String path = request.getServletContext().getRealPath("/upload/");
		// 创建该文件对象
		File file = new File(path + "/" + filename);
		// 设置响应头
		HttpHeaders headers = new HttpHeaders();
		// 通知浏览器以下载的方式打开文件
		headers.setContentDispositionFormData("attachment", filename);
		// 定义以流的形式返回文件数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 使用springmvc框架的ResponseEntity对象封装返回下载数据
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}

	/**
	 * 视频浏览
	 */
	@RequestMapping(value = "/showVideo")
	public void showVideo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("application/octet-stream");
		String fname = request.getParameter("filename");
		String newpath = new String(fname.getBytes("ISO-8859-1"), "UTF-8");
		String absolutePath = path + newpath;
		FileInputStream fis = new FileInputStream(absolutePath);
		OutputStream os = response.getOutputStream();
		try {
			int count = 0;
			byte[] buffer = new byte[1024 * 1024];
			while ((count = fis.read(buffer)) != -1)
				os.write(buffer, 0, count);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				os.close();
			if (fis != null)
				fis.close();
		}
	}
}
