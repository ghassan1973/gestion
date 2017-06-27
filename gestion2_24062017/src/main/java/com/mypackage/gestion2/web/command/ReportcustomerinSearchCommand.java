package com.mypackage.gestion2.web.command;

public class ReportcustomerinSearchCommand implements SearchCommand{
	private Integer page = 0;
	private Integer size = 10;

	private String orderId;
	
	private String inOut;
	private String projectName;
    private String tierName;
    private String orderName;
    private String credit;
    private String debt;
    private String balance;
	

	public String getOrderId()
	{
		return this.orderId;
	}
	
	public void setOrderId(String _orderId)
	{
		this.orderId = _orderId;
	}

	
	
	public String getInOut()
	{
		return this.inOut;
	}
	
	public void setInOut(String _inOut)
	{
		this.inOut = _inOut;
	}

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

public String getTierName()
	{
		return this.tierName;
	}
	public void setTierName(String _tierName)
	{
		this.tierName = _tierName;
	}

	public String getOrderName()
	{
		return this.orderName;
	}
	public void setOrderName(String _orderName)
	{
		this.orderName = _orderName;
	}
	
public String getCredit()
	{
		return this.credit;
	}
	public void setCredit(String _credit)
	{
		this.credit = _credit;
	}

public String getDebt()
	{
		return this.debt;
	}
	public void setDebt(String _debt)
	{
		this.debt = _debt;
	}


	
public String getBalance()
	{
		return this.balance;
	}
	public void setBalance(String _balance)
	{
		this.balance = _balance;
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
