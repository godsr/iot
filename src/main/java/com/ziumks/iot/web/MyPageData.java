package com.ziumks.iot.web;

import java.util.ArrayList;
import java.util.List;

public class MyPageData {

	long recordsTotal = 0;
	long recordsFiltered = 0;
    List data = new ArrayList();
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
    
}
