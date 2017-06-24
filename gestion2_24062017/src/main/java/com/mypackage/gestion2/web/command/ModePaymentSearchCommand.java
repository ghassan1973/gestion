package com.mypackage.gestion2.web.command;

public class ModePaymentSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String modePaymentName;

	/**
	*
	*/
	public String getModePaymentName()
	{
		return this.modePaymentName;
	}
	
	
	/**
	*
	*/
	public void setModePaymentName(String _modePaymentName)
	{
		this.modePaymentName = _modePaymentName;
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
