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

import com.mypackage.gestion2.model.Role;


@Entity
@Table(name="tbl_permission")
public class Permission {

//1750 PermissionId PRIMARY_KEY $prop.getRelationshipType() false
//1751 PermissionName TEXT $prop.getRelationshipType() false
//$prop.getId() Permissions REFERENCE MANY_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="permission_id")
	private Long permissionId;

	@Column(name="permission_name")
	    
    private String permissionName;






	
	/**
	*
	*/
	public Long getPermissionId()
	{
		return this.permissionId;
	}
	
	
	/**
	*
	*/
	public void setPermissionId(Long _permissionId)
	{
		this.permissionId = _permissionId;
	}
	/**
	*
	*/
	public String getPermissionName()
	{
		return this.permissionName;
	}
	
	
	/**
	*
	*/
	public void setPermissionName(String _permissionName)
	{
		this.permissionName = _permissionName;
	}




	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;

		if (permissionId == null) {
			if (other.permissionId != null)
				return false;
		}else if (!permissionId.equals(other.permissionId))
			return false;

				if (permissionName == null) {
			if (other.permissionName != null)
				return false;
		} else if (!permissionName.equals(other.permissionName))
			return false;
				
		return true;
	}
}
