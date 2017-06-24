package com.mypackage.gestion2.web.command;

public class CurrencySearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String currencyName;

	/**
	*
	*/
	public String getCurrencyName()
	{
		return this.currencyName;
	}
	
	
	/**
	*
	*/
	public void setCurrencyName(String _currencyName)
	{
		this.currencyName = _currencyName;
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
