package com.mypackage.gestion2.web.command;

public class PermissionSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String permissionName;

	/**
	*
	*/
	public String getPermissionName()
	{
		return this.permissionName;
	}
	
	
	/**
	*
	*/
	public void setPermissionName(String _permissionName)
	{
		this.permissionName = _permissionName;
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
