package com.spring.ex;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean{

		ServletContext servletContext;
	
		public void init() {
			System.out.println("===init===");
		}
		
		public void afterPropertiesSet() throws Exception{
			System.out.println("==afterPropertiesSet===");
			String uploadPath = servletContext.getRealPath("/resources/");
			System.out.println(uploadPath);
			File destination = new File(uploadPath);
			
			String str = "c:tempUpload";
			File destination_local = new File(str);
			
			//폴더째 카피
			FileUtils.copyDirectory(destination_local,destination);
		}
}

