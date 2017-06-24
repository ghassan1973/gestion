package com.mypackage.gestion2.web.command;

public class RoleSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String roleName;

	/**
	*
	*/
	public String getRoleName()
	{
		return this.roleName;
	}
	
	
	/**
	*
	*/
	public void setRoleName(String _roleName)
	{
		this.roleName = _roleName;
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
