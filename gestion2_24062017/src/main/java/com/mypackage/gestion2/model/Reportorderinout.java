package com.mypackage.gestion2.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;



@Entity
@Table(name="reportorderinout")
public class Reportorderinout {

//1750 PermissionId PRIMARY_KEY $prop.getRelationshipType() false
//1751 PermissionName TEXT $prop.getRelationshipType() false
//$prop.getId() Permissions REFERENCE MANY_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="in_out")
	private String inOut;
	
	@Column(name="project_name")
	private String projectName;

	@Column(name="tier_name")
    private String tierName;
	
	@Column(name="order_name")
    private String orderName;

	@Column(name="Credit")
    private String credit;
	
	@Column(name="Debt")
    private String debt;

	@Column(name="Balance")
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



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reportorderinout other = (Reportorderinout) obj;

if (orderId == null) {
			if (other.orderId != null)
				return false;
		}else if (!orderId.equals(other.orderId))
			return false;
		
				if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
				
		return true;
	}
}
