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
@Table(name="tbl_mode_payment")
public class ModePayment {

//1760 ModePaymentId PRIMARY_KEY $prop.getRelationshipType() true
//1761 ModePaymentName TEXT $prop.getRelationshipType() true
//$prop.getId() Mode REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mode_payment_id")
	private Long modePaymentId;

	@Column(name="mode_payment_name")
	    
    private String modePaymentName;


	@OneToMany(mappedBy="modePayment")
	private List<Transaction> mode;




	
	/**
	*
	*/
	public Long getModePaymentId()
	{
		return this.modePaymentId;
	}
	
	
	/**
	*
	*/
	public void setModePaymentId(Long _modePaymentId)
	{
		this.modePaymentId = _modePaymentId;
	}
	/**
	*
	*/
	public String getModePaymentName()
	{
		return this.modePaymentName;
	}
	
	
	/**
	*
	*/
	public void setModePaymentName(String _modePaymentName)
	{
		this.modePaymentName = _modePaymentName;
	}

	/**
	*
	*/
	public List<Transaction> getMode()
	{
		return this.mode;
	}
	
	
	/**
	*
	*/
	public void setMode(List<Transaction> _mode)
	{
		this.mode = _mode;
	}



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModePayment other = (ModePayment) obj;

		if (modePaymentId == null) {
			if (other.modePaymentId != null)
				return false;
		}else if (!modePaymentId.equals(other.modePaymentId))
			return false;

				if (modePaymentName == null) {
			if (other.modePaymentName != null)
				return false;
		} else if (!modePaymentName.equals(other.modePaymentName))
			return false;
				
		return true;
	}
}
