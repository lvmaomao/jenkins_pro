package com.appmarket.index;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtil {

	public static final String DIR = "apps/";

	public static List<AppBean> getFiles(String path) {
		List<AppBean> appBeans = new ArrayList<AppBean>();
		File file = new File(path);
		File[] tempList = file.listFiles();
		AppBean app;
		for (File appFile : tempList) {
			if (appFile.isFile()) {
				app = new AppBean();
				app.appName = appFile.getName();
				app.appLength = appFile.length();
				app.appUrl = "downloadfile?filename=" + appFile.getName();
				app.appDate = TimeUtil.getDateFromTimestampYMDHMS(appFile.lastModified());
				app.appCreateAt = appFile.lastModified();
				app.appSize = String.format("%.2f MB", (double) appFile.length() / 1024 /1024);
				appBeans.add(app);
			}
		}
		Collections.sort(appBeans);
		return appBeans;
	}

}
