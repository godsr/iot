package com.ziumks.iot.response;

import com.google.common.base.Strings;

public class TagInfoPageInfo {

	private String page;
	private String totalPage;
	private String rows;
	private String currentRows;
	private String totalRows;
	
	public void execute() {
		
		if (!Strings.isNullOrEmpty(totalRows)) {
			
			int totalRowsInt = Integer.parseInt(totalRows);
			int pageInt = Integer.parseInt(page);
			int rowsInt = Integer.parseInt(rows);
			int currentRowsInt = 0;
			int totalPageInt = 0;
			
			if (totalRowsInt != 0) {
				int mod = totalRowsInt % rowsInt ; 
				totalPageInt = mod == 0 ? totalRowsInt / rowsInt : totalRowsInt / rowsInt + 1;
				if (pageInt == totalPageInt) {
					currentRowsInt = mod == 0 ? rowsInt : mod ;
				} else {
					currentRowsInt = rowsInt;
				}
			}
			
			this.page = String.valueOf(pageInt);
			this.totalPage = String.valueOf(totalPageInt);
			this.rows = String.valueOf(rowsInt);
			this.currentRows = String.valueOf(currentRowsInt);
			this.totalRows = String.valueOf(totalRowsInt);
			
		}
		
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public String getCurrentRows() {
		return currentRows;
	}
	public void setCurrentRows(String currentRows) {
		this.currentRows = currentRows;
	}
	public String getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
}
