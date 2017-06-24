package com.mypackage.gestion2.web.command;

public class ProductSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String productName;

	/**
	*
	*/
	public String getProductName()
	{
		return this.productName;
	}
	
	
	/**
	*
	*/
	public void setProductName(String _productName)
	{
		this.productName = _productName;
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
