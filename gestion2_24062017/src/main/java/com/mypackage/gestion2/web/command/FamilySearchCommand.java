package com.mypackage.gestion2.web.command;

public class FamilySearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String familyName;

	/**
	*
	*/
	public String getFamilyName()
	{
		return this.familyName;
	}
	
	
	/**
	*
	*/
	public void setFamilyName(String _familyName)
	{
		this.familyName = _familyName;
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
