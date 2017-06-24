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

import com.mypackage.gestion2.model.Product;


@Entity
@Table(name="tbl_family")
public class Family {

//1754 FamilyId PRIMARY_KEY $prop.getRelationshipType() true
//1755 FamilyName TEXT $prop.getRelationshipType() true
//$prop.getId() Family REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="family_id")
	private Long familyId;

	@Column(name="family_name")
	    
    private String familyName;


	@OneToMany(mappedBy="family")
	private List<Product> family;




	
	/**
	*
	*/
	public Long getFamilyId()
	{
		return this.familyId;
	}
	
	
	/**
	*
	*/
	public void setFamilyId(Long _familyId)
	{
		this.familyId = _familyId;
	}
	/**
	*
	*/
	public String getFamilyName()
	{
		return this.familyName;
	}
	
	
	/**
	*
	*/
	public void setFamilyName(String _familyName)
	{
		this.familyName = _familyName;
	}

	/**
	*
	*/
	public List<Product> getFamily()
	{
		return this.family;
	}
	
	
	/**
	*
	*/
	public void setFamily(List<Product> _family)
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
		Family other = (Family) obj;

		if (familyId == null) {
			if (other.familyId != null)
				return false;
		}else if (!familyId.equals(other.familyId))
			return false;

				if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
				
		return true;
	}
}
