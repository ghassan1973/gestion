package com.mypackage.gestion2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tbl_order_lines")
public class OrderLines {

	//1807 OrderLinesId PRIMARY_KEY $prop.getRelationshipType() true
	//1808 OrderLinesName TEXT $prop.getRelationshipType() true
	//1809 Quantity NUMBER $prop.getRelationshipType() true
	//1810 UnitPrice NUMBER $prop.getRelationshipType() true
	//1811 Discount TEXT $prop.getRelationshipType() true
	//1812 Product REFERENCE MANY_TO_ONE true
	//1814 Order REFERENCE MANY_TO_ONE true
	//1837 Comment TEXT $prop.getRelationshipType() true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_lines_id")
	private Long orderLinesId;

	@Column(name="order_lines_name")

	private String orderLinesName;

	@Column(name="quantity")

	private Integer quantity;

	@Column(name="unit_price")

	private Integer unitPrice;

	@Column(name="discount")

	private String discount;

	@Column(name="comment")

	private String comment;



	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;




	/**
	 *
	 */
	public Long getOrderLinesId()
	{
		return this.orderLinesId;
	}


	/**
	 *
	 */
	public void setOrderLinesId(Long _orderLinesId)
	{
		this.orderLinesId = _orderLinesId;
	}
	/**
	 *
	 */
	public String getOrderLinesName()
	{
		return this.orderLinesName;
	}


	/**
	 *
	 */
	public void setOrderLinesName(String _orderLinesName)
	{
		this.orderLinesName = _orderLinesName;
	}
	/**
	 *
	 */
	public Integer getQuantity()
	{
		return this.quantity;
	}


	/**
	 *
	 */
	public void setQuantity(Integer _quantity)
	{
		this.quantity = _quantity;
	}
	/**
	 *
	 */
	public Integer getUnitPrice()
	{
		return this.unitPrice;
	}


	/**
	 *
	 */
	public void setUnitPrice(Integer _unitPrice)
	{
		this.unitPrice = _unitPrice;
	}
	/**
	 *
	 */
	public String getDiscount()
	{
		return this.discount;
	}


	/**
	 *
	 */
	public void setDiscount(String _discount)
	{
		this.discount = _discount;
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
	public Product getProduct()
	{
		return this.product;
	}


	/**
	 *
	 */
	public void setProduct(Product _product)
	{
		this.product = _product;
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
/*
	@Transient
	public String getNaturalKey(){
		List<String> list = new ArrayList();
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
		OrderLines other = (OrderLines) obj;

		if (orderLinesId == null) {
			if (other.orderLinesId != null)
				return false;
		}else if (!orderLinesId.equals(other.orderLinesId))
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
