package com.mypackage.gestion2.web.command;

public class OrderLinesSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String orderLinesName;

	/**
	*
	*/
	public String getOrderLinesName()
	{
		return this.orderLinesName;
	}
	
	
	/**
	*
	*/
	public void setOrderLinesName(String _orderLinesName)
	{
		this.orderLinesName = _orderLinesName;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
