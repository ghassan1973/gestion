package com.mypackage.gestion2.web.command;

public class TierSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String tierName;
	private String type;

	/**
	*
	*/
	public String getTierName()
	{
		return this.tierName;
	}
	
	
	/**
	*
	*/
	public void setTierName(String _tierName)
	{
		this.tierName = _tierName;
	}
	/**
	*
	*/
	public String getType()
	{
		return this.type;
	}
	
	
	/**
	*
	*/
	public void setType(String _type)
	{
		this.type = _type;
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
