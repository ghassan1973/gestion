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

import com.mypackage.gestion2.model.OrderLines;


@Entity
@Table(name="tbl_product")
public class Product {

//1756 ProductId PRIMARY_KEY $prop.getRelationshipType() true
//1757 ProductName TEXT $prop.getRelationshipType() true
//1758 Family REFERENCE MANY_TO_ONE true
//1759 UnitPrice NUMBER $prop.getRelationshipType() true
//1815 Tva1 TEXT $prop.getRelationshipType() true
//1816 Tva2 TEXT $prop.getRelationshipType() true
//$prop.getId() Product REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long productId;

	@Column(name="product_name")
	    
    private String productName;

	@Column(name="unit_price")
	    
    private Integer unitPrice;

	@Column(name="tva1")
	    
    private String tva1;

	@Column(name="tva2")
	    
    private String tva2;


	@OneToMany(mappedBy="product")
	private List<OrderLines> product;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;



	
	/**
	*
	*/
	public Long getProductId()
	{
		return this.productId;
	}
	
	
	/**
	*
	*/
	public void setProductId(Long _productId)
	{
		this.productId = _productId;
	}
	/**
	*
	*/
	public String getProductName()
	{
		return this.productName;
	}
	
	
	/**
	*
	*/
	public void setProductName(String _productName)
	{
		this.productName = _productName;
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
	public String getTva1()
	{
		return this.tva1;
	}
	
	
	/**
	*
	*/
	public void setTva1(String _tva1)
	{
		this.tva1 = _tva1;
	}
	/**
	*
	*/
	public String getTva2()
	{
		return this.tva2;
	}
	
	
	/**
	*
	*/
	public void setTva2(String _tva2)
	{
		this.tva2 = _tva2;
	}

	/**
	*
	*/
	public List<OrderLines> getProduct()
	{
		return this.product;
	}
	
	
	/**
	*
	*/
	public void setProduct(List<OrderLines> _product)
	{
		this.product = _product;
	}


    /**
    *
    */
    public Family getFamily()
    {
        return this.family;
    }


    /**
    *
    */
    public void setFamily(Family _family)
    {
        this.family = _family;
    }

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;

		if (productId == null) {
			if (other.productId != null)
				return false;
		}else if (!productId.equals(other.productId))
			return false;

				if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
				
		return true;
	}
}
