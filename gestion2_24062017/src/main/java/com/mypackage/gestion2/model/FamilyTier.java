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

import com.mypackage.gestion2.model.Tier;


@Entity
@Table(name="tbl_family_tier")
public class FamilyTier {

//1795 FamilyTierId PRIMARY_KEY $prop.getRelationshipType() true
//1796 FamilyTierName TEXT $prop.getRelationshipType() true
//$prop.getId() Type REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="family_tier_id")
	private Long familyTierId;

	@Column(name="family_tier_name")
	    
    private String familyTierName;


	@OneToMany(mappedBy="familyTier")
	private List<Tier> type;




	
	/**
	*
	*/
	public Long getFamilyTierId()
	{
		return this.familyTierId;
	}
	
	
	/**
	*
	*/
	public void setFamilyTierId(Long _familyTierId)
	{
		this.familyTierId = _familyTierId;
	}
	/**
	*
	*/
	public String getFamilyTierName()
	{
		return this.familyTierName;
	}
	
	
	/**
	*
	*/
	public void setFamilyTierName(String _familyTierName)
	{
		this.familyTierName = _familyTierName;
	}

	/**
	*
	*/
	public List<Tier> getType()
	{
		return this.type;
	}
	
	
	/**
	*
	*/
	public void setType(List<Tier> _type)
	{
		this.type = _type;
	}



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FamilyTier other = (FamilyTier) obj;

		if (familyTierId == null) {
			if (other.familyTierId != null)
				return false;
		}else if (!familyTierId.equals(other.familyTierId))
			return false;

				if (familyTierName == null) {
			if (other.familyTierName != null)
				return false;
		} else if (!familyTierName.equals(other.familyTierName))
			return false;
				
		return true;
	}
}
