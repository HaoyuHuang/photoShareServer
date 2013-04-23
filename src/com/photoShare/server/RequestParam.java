package com.photoShare.server;

import org.apache.struts2.json.annotations.JSON;

public class RequestParam {
	public int currentPage;

	public int demandPage;

	public String fields;

	public String method;

	@JSON(serialize = false)
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		System.out.println("Current Page: " + currentPage);
		this.currentPage = currentPage;
	}

	@JSON(serialize = false)
	public int getDemandPage() {
		return demandPage;
	}

	public void setDemandPage(int demandPage) {
		this.demandPage = demandPage;
	}

	@JSON(serialize = false)
	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	@JSON(serialize = false)
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
