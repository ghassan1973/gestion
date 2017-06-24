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

import com.mypackage.gestion2.model.Transaction;


@Entity
@Table(name="tbl_currency")
public class Currency {

//1762 CurrencyId PRIMARY_KEY $prop.getRelationshipType() true
//1763 CurrencyName TEXT $prop.getRelationshipType() true
//$prop.getId() Currency REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="currency_id")
	private Long currencyId;

	@Column(name="currency_name")
	    
    private String currencyName;


	@OneToMany(mappedBy="currency")
	private List<Transaction> currency;




	
	/**
	*
	*/
	public Long getCurrencyId()
	{
		return this.currencyId;
	}
	
	
	/**
	*
	*/
	public void setCurrencyId(Long _currencyId)
	{
		this.currencyId = _currencyId;
	}
	/**
	*
	*/
	public String getCurrencyName()
	{
		return this.currencyName;
	}
	
	
	/**
	*
	*/
	public void setCurrencyName(String _currencyName)
	{
		this.currencyName = _currencyName;
	}

	/**
	*
	*/
	public List<Transaction> getCurrency()
	{
		return this.currency;
	}
	
	
	/**
	*
	*/
	public void setCurrency(List<Transaction> _currency)
	{
		this.currency = _currency;
	}



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;

		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		}else if (!currencyId.equals(other.currencyId))
			return false;

				if (currencyName == null) {
			if (other.currencyName != null)
				return false;
		} else if (!currencyName.equals(other.currencyName))
			return false;
				
		return true;
	}
}
