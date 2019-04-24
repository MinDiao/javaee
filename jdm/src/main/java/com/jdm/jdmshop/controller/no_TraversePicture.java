package com.jdm.jdmshop.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件预览辅助类
 * @author lhb
 * 
 */

@Controller
public class no_TraversePicture {
	
	 /**
     * 通过ajax请求获取传入的文件路径里边的文件fileList数组
     * @param req
     * @param resp
     * @param params 文件夹路径参数
     * @return
     * @throws ServletException
     * @throws IOException
     * @throws MalformedURLException
     */
    @RequestMapping("getFileList")
    @ResponseBody
    protected ArrayList<String> CalculateGeoServlet(HttpServletRequest req, HttpServletResponse resp, String params) 
    		throws ServletException, IOException, MalformedURLException {
        ArrayList<String> fileList=new ArrayList<String>();
        fileList=getFiles(params);
        return fileList;
    }
    /**
     * 通过递归得到某一路径下所有的目录及其文件
     * @param filePath 文件路径
     * @return
     */
    public static ArrayList<String> getFiles(String filePath) {
        ArrayList<String> fileList = new ArrayList<String>();
        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                /*
                 * 递归调用
                 */
                getFiles(file.getAbsolutePath());
                fileList.add(file.getAbsolutePath());
            } else {
              //  String picPathStr = file.getAbsolutePath();
              String picPathStr = file.getAbsolutePath().replaceAll("\\\\","//");
                fileList.add(picPathStr);
            }
        }
        /*for(String str:fileList){
            System.out.println(str);
        }*/
        return fileList;
    }

}




