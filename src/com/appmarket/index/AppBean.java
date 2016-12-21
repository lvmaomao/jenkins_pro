package com.appmarket.index;

public class AppBean implements Comparable<AppBean> {

	public String appName;
	public long appLength;//文件长度 long
	public String appUrl;
	public String appDate;
	public long appCreateAt;
	public String appSize;//文件大小 单位M
	
	public AppBean(){
		
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public long getAppLength() {
		return appLength;
	}

	public void setAppLength(long appLength) {
		this.appLength = appLength;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getAppDate() {
		return appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public long getAppCreateAt() {
		return appCreateAt;
	}

	public void setAppCreateAt(long appCreateAt) {
		this.appCreateAt = appCreateAt;
	}

	
	public String getAppSize() {
		return appSize;
	}

	public void setAppSize(String appSize) {
		this.appSize = appSize;
	}

	@Override
	public int compareTo(AppBean another) {
	    if (this.appCreateAt == another.appCreateAt) {
	        return 0;
	    }
	    return this.appCreateAt < another.appCreateAt ? 1 : -1;
	}
	
}
