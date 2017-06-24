package com.mypackage.gestion2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tbl_transaction")
public class Transaction {

	//1827 TransactionId PRIMARY_KEY $prop.getRelationshipType() true
	//1828 TransactionName TEXT $prop.getRelationshipType() true
	//1829 Order REFERENCE MANY_TO_ONE true
	//1830 Date DATE $prop.getRelationshipType() true
	//1831 Amount NUMBER $prop.getRelationshipType() true
	//1832 PieceNum TEXT $prop.getRelationshipType() true
	//1833 Currency REFERENCE MANY_TO_ONE true
	//1834 Mode REFERENCE MANY_TO_ONE true
	//1835 Comment TEXT $prop.getRelationshipType() true
	//1836 InOut DROPDOWN $prop.getRelationshipType() true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Long transactionId;

	@Column(name="transaction_name")

	private String transactionName;

	@Column(name="date")

	private java.util.Date date;

	@Column(name="amount")

	private Integer amount;

	@Column(name="piece_num")

	private String pieceNum;

	@Column(name="comment")

	private String comment;

	@Column(name="in_out")
	//@Enumerated(EnumType.STRING)

	private String inOut;



	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@ManyToOne
	@JoinColumn(name = "currency_id")
	private Currency currency;
	@ManyToOne
	@JoinColumn(name = "mode_payment_id")
	private ModePayment modePayment;




	/**
	 *
	 */
	public Long getTransactionId()
	{
		return this.transactionId;
	}


	/**
	 *
	 */
	public void setTransactionId(Long _transactionId)
	{
		this.transactionId = _transactionId;
	}
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
	public String getPieceNum()
	{
		return this.pieceNum;
	}


	/**
	 *
	 */
	public void setPieceNum(String _pieceNum)
	{
		this.pieceNum = _pieceNum;
	}
	/**
	 *
	 */
	public String getComment()
	{
		return this.comment;
	}


	/**
	 *
	 */
	public void setComment(String _comment)
	{
		this.comment = _comment;
	}
	/**
	 *
	 */
	public String getInOut()
	{
		return this.inOut;
	}


	/**
	 *
	 */
	public void setInOut(String _inOut)
	{
		this.inOut = _inOut;
	}



	/**
	 *
	 */
	public Order getOrder()
	{
		return this.order;
	}


	/**
	 *
	 */
	public void setOrder(Order _order)
	{
		this.order = _order;
	}
	/**
	 *
	 */
	public Currency getCurrency()
	{
		return this.currency;
	}


	/**
	 *
	 */
	public void setCurrency(Currency _currency)
	{
		this.currency = _currency;
	}
	/**
	 *
	 */
	public ModePayment getModePayment()
	{
		return this.modePayment;
	}


	/**
	 *
	 */
	public void setModePayment(ModePayment _modePayment)
	{
		this.modePayment = _modePayment;
	}
/*
	@Transient
	public String getNaturalKey(){
		List<String> list = new ArrayList();
		list.add(this.get${helper.asClassName($prop)}());
		list.add(this.get${helper.asClassName($prop)}());
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
		Transaction other = (Transaction) obj;

		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		}else if (!transactionId.equals(other.transactionId))
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
