package com.mypackage.gestion2.web.command;

public class TransactionSearchCommand implements SearchCommand{

	private Integer page = 0;
	
	private Integer size = 10;

	private String transactionName;

	/**
	*
	*/
	public String getTransactionName()
	{
		return this.transactionName;
	}
	
	
	/**
	*
	*/
	public void setTransactionName(String _transactionName)
	{
		this.transactionName = _transactionName;
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
