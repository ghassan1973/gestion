package com.mypackage.gestion2.web.command;

public class RegionSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String regionName;

	/**
	*
	*/
	public String getRegionName()
	{
		return this.regionName;
	}
	
	
	/**
	*
	*/
	public void setRegionName(String _regionName)
	{
		this.regionName = _regionName;
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
