package com.mypackage.gestion2.web.command;

public class FamilyTierSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String familyTierName;

	/**
	*
	*/
	public String getFamilyTierName()
	{
		return this.familyTierName;
	}
	
	
	/**
	*
	*/
	public void setFamilyTierName(String _familyTierName)
	{
		this.familyTierName = _familyTierName;
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
