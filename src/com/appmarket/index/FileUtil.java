package com.appmarket.index;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public static final String IP = "http://localhost:8080/AppMarket/";
	public static final String DIR = "apps/";
	
	public static List<AppBean> getFiles(String path){
		List<AppBean> appBeans = new ArrayList<AppBean>();
		File file = new File(path);
		File[] tempList = file.listFiles();
		AppBean app;
		for (File appFile :tempList){
			if (appFile.isFile()) {
				app = new AppBean();
				app.appName = appFile.getName();
				app.appLength = appFile.length();
				app.appUrl = IP + DIR + appFile.getName();
				appBeans.add(app);
			}
		}
		return appBeans;
	}

}
