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
@Table(name="tbl_tier")
public class Tier {

	//1797 TierId PRIMARY_KEY $prop.getRelationshipType() true
	//1798 TierName TEXT $prop.getRelationshipType() true
	//1799 Type REFERENCE MANY_TO_ONE true
	//1800 Address1 TEXT $prop.getRelationshipType() true
	//1801 Address2 TEXT $prop.getRelationshipType() true
	//1802 Mobile TEXT $prop.getRelationshipType() true
	//1803 Phone TEXT $prop.getRelationshipType() true
	//1804 Email EMAIL_ADDRESS $prop.getRelationshipType() true
	//$prop.getId() Tier REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tier_id")
	private Long tierId;

	@Column(name="tier_name")

	private String tierName;

	@Column(name="address1")

	private String address1;

	@Column(name="address2")

	private String address2;

	@Column(name="mobile")

	private String mobile;

	@Column(name="phone")

	private String phone;

	@Column(name="email")

	private String email;


	@OneToMany(mappedBy="tier")
	private List<Order> tier;

	@ManyToOne
	@JoinColumn(name = "family_tier_id")
	private FamilyTier familyTier;




	/**
	 *
	 */
	public Long getTierId()
	{
		return this.tierId;
	}


	/**
	 *
	 */
	public void setTierId(Long _tierId)
	{
		this.tierId = _tierId;
	}
	/**
	 *
	 */
	public String getTierName()
	{
		return this.tierName;
	}


	/**
	 *
	 */
	public void setTierName(String _tierName)
	{
		this.tierName = _tierName;
	}
	/**
	 *
	 */
	public String getAddress1()
	{
		return this.address1;
	}


	/**
	 *
	 */
	public void setAddress1(String _address1)
	{
		this.address1 = _address1;
	}
	/**
	 *
	 */
	public String getAddress2()
	{
		return this.address2;
	}


	/**
	 *
	 */
	public void setAddress2(String _address2)
	{
		this.address2 = _address2;
	}
	/**
	 *
	 */
	public String getMobile()
	{
		return this.mobile;
	}


	/**
	 *
	 */
	public void setMobile(String _mobile)
	{
		this.mobile = _mobile;
	}
	/**
	 *
	 */
	public String getPhone()
	{
		return this.phone;
	}


	/**
	 *
	 */
	public void setPhone(String _phone)
	{
		this.phone = _phone;
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

	/**
	 *
	 */
	public List<Order> getTier()
	{
		return this.tier;
	}


	/**
	 *
	 */
	public void setTier(List<Order> _tier)
	{
		this.tier = _tier;
	}


	/**
	 *
	 */
	public FamilyTier getFamilyTier()
	{
		return this.familyTier;
	}


	/**
	 *
	 */
	public void setFamilyTier(FamilyTier _familyTier)
	{
		this.familyTier = _familyTier;
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
		Tier other = (Tier) obj;

		if (tierId == null) {
			if (other.tierId != null)
				return false;
		}else if (!tierId.equals(other.tierId))
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
