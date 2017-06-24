package com.mypackage.gestion2.web.command;

public class ProjectSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String projectName;

	/**
	*
	*/
	public String getProjectName()
	{
		return this.projectName;
	}
	
	
	/**
	*
	*/
	public void setProjectName(String _projectName)
	{
		this.projectName = _projectName;
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
