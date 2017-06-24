package com.mypackage.gestion2.web.command;

public class UserSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String firstName;
	private String lastName;
	private String email;

	/**
	*
	*/
	public String getFirstName()
	{
		return this.firstName;
	}
	
	
	/**
	*
	*/
	public void setFirstName(String _firstName)
	{
		this.firstName = _firstName;
	}
	/**
	*
	*/
	public String getLastName()
	{
		return this.lastName;
	}
	
	
	/**
	*
	*/
	public void setLastName(String _lastName)
	{
		this.lastName = _lastName;
	}
	/**
	*
	*/
	public String getEmail()
	{
		return this.email;
	}
	
	
	/**
	*
	*/
	public void setEmail(String _email)
	{
		this.email = _email;
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
