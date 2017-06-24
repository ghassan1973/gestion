package com.mypackage.gestion2.web.command;

public class ProjectTypeSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String projectTypeName;

	/**
	*
	*/
	public String getProjectTypeName()
	{
		return this.projectTypeName;
	}
	
	
	/**
	*
	*/
	public void setProjectTypeName(String _projectTypeName)
	{
		this.projectTypeName = _projectTypeName;
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
