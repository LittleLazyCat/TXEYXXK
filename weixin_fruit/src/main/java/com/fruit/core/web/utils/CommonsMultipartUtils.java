package com.fruit.core.web.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class CommonsMultipartUtils {

	public static void upPhoto(HttpServletRequest request,String path)  {
		try {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			if(multipartResolver.isMultipart(request)){  
			    MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
			    Iterator<String> iter = multiRequest.getFileNames();  
			    while(iter.hasNext()){  
			        MultipartFile file = multiRequest.getFile(iter.next());  
			        if(file != null){  
			            String myFileName = file.getOriginalFilename();  
			            if(myFileName.trim() !=""){  
			                String fileName =  file.getOriginalFilename();  
			                fileName = fileName.substring(0, fileName.lastIndexOf(".")) + ".jpg";
			                // 改写成自己的磁盘路径
			                String windows = "E:\\room\\" + fileName;
			                String linux = "/usr/local/room/" + fileName;
			                file.transferTo(new File(linux));
			            }  
			        }  
			    }  
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
}
