package com.mypackage.gestion2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tbl_order")
public class Order {

	//1784 OrderId PRIMARY_KEY $prop.getRelationshipType() true
	//1785 OrderName TEXT $prop.getRelationshipType() true
	//1786 Date DATE $prop.getRelationshipType() true
	//1787 Amount NUMBER $prop.getRelationshipType() true
	//1790 TotalSettlement NUMBER $prop.getRelationshipType() true
	//1791 Balance NUMBER $prop.getRelationshipType() true
	//1792 Project REFERENCE MANY_TO_ONE true
	//1838 Tier REFERENCE MANY_TO_ONE true
	//$prop.getId() Order REFERENCE ONE_TO_MANY true
	//$prop.getId() Order REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private Long orderId;

	@Column(name="order_name")

	private String orderName;

	@Column(name="date")

	private java.util.Date date;

	@Column(name="amount")

	private Integer amount;

	@Column(name="total_settlement")

	private Integer totalSettlement;

	@Column(name="balance")

	private Integer balance;


	@OneToMany(mappedBy="order")
	private List<OrderLines> order;
	/*	@OneToMany(mappedBy="transaction")
	private List<Transaction> transaction;
	 */
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@ManyToOne
	@JoinColumn(name = "tier_id")
	private Tier tier;




	/**
	 *
	 */
	public Long getOrderId()
	{
		return this.orderId;
	}


	/**
	 *
	 */
	public void setOrderId(Long _orderId)
	{
		this.orderId = _orderId;
	}
	/**
	 *
	 */
	public String getOrderName()
	{
		return this.orderName;
	}


	/**
	 *
	 */
	public void setOrderName(String _orderName)
	{
		this.orderName = _orderName;
	}
	/**
	 *
	 */
	public java.util.Date getDate()
	{
		return this.date;
	}


	/**
	 *
	 */
	public void setDate(java.util.Date _date)
	{
		this.date = _date;
	}
	/**
	 *
	 */
	public Integer getAmount()
	{
		return this.amount;
	}


	/**
	 *
	 */
	public void setAmount(Integer _amount)
	{
		this.amount = _amount;
	}
	/**
	 *
	 */
	public Integer getTotalSettlement()
	{
		return this.totalSettlement;
	}


	/**
	 *
	 */
	public void setTotalSettlement(Integer _totalSettlement)
	{
		this.totalSettlement = _totalSettlement;
	}
	/**
	 *
	 */
	public Integer getBalance()
	{
		return this.balance;
	}


	/**
	 *
	 */
	public void setBalance(Integer _balance)
	{
		this.balance = _balance;
	}

	/**
	 *
	 */
	public List<OrderLines> getOrder()
	{
		return this.order;
	}


	/**
	 *
	 */
	public void setOrder(List<OrderLines> _order)
	{
		this.order = _order;
	}

/*	*//**
	 *
	 *//*
	public List<Transaction> getTransaction()
	{
		return this.transaction;
	}


	*//**
	 *
	 *//*
	public void setTransaction(List<Transaction> _transaction)
	{
		this.transaction = _transaction;
	}
*/

	/**
	 *
	 */
	public Project getProject()
	{
		return this.project;
	}


	/**
	 *
	 */
	public void setProject(Project _project)
	{
		this.project = _project;
	}
	/**
	 *
	 */
	public Tier getTier()
	{
		return this.tier;
	}


	/**
	 *
	 */
	public void setTier(Tier _tier)
	{
		this.tier = _tier;
	}
	/*
	@Transient
	public String getNaturalKey(){
		List<String> list = new ArrayList();
		list.add(this.get${helper.asClassName($prop)}());
		list.add(this.get${helper.asClassName($prop)}());
		list.add(this.get${helper.asClassName($prop)}());
		return StringUtils.join(list,",");
	}
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;

		if (orderId == null) {
			if (other.orderId != null)
				return false;
		}else if (!orderId.equals(other.orderId))
			return false;
		/*
		if (getNaturalKeys() == null) {
			if (other.getNaturalKeys() != null)
				return false;
		} else if (!getNaturalKeys().equals(other.getNaturalKeys()))
			return false;
		 */
		return true;
	}
}
