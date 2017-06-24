package com.mypackage.gestion2.web.command;

public class ProjectStatusSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String projectStatusName;

	/**
	*
	*/
	public String getProjectStatusName()
	{
		return this.projectStatusName;
	}
	
	
	/**
	*
	*/
	public void setProjectStatusName(String _projectStatusName)
	{
		this.projectStatusName = _projectStatusName;
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
