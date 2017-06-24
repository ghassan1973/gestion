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

import com.mypackage.gestion2.model.Project;


@Entity
@Table(name="tbl_region")
public class Region {

//1766 RegionId PRIMARY_KEY $prop.getRelationshipType() true
//1767 RegionName TEXT $prop.getRelationshipType() true
//$prop.getId() Region REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="region_id")
	private Long regionId;

	@Column(name="region_name")
	    
    private String regionName;


	@OneToMany(mappedBy="region")
	private List<Project> region;




	
	/**
	*
	*/
	public Long getRegionId()
	{
		return this.regionId;
	}
	
	
	/**
	*
	*/
	public void setRegionId(Long _regionId)
	{
		this.regionId = _regionId;
	}
	/**
	*
	*/
	public String getRegionName()
	{
		return this.regionName;
	}
	
	
	/**
	*
	*/
	public void setRegionName(String _regionName)
	{
		this.regionName = _regionName;
	}

	/**
	*
	*/
	public List<Project> getRegion()
	{
		return this.region;
	}
	
	
	/**
	*
	*/
	public void setRegion(List<Project> _region)
	{
		this.region = _region;
	}



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;

		if (regionId == null) {
			if (other.regionId != null)
				return false;
		}else if (!regionId.equals(other.regionId))
			return false;

				if (regionName == null) {
			if (other.regionName != null)
				return false;
		} else if (!regionName.equals(other.regionName))
			return false;
				
		return true;
	}
}
