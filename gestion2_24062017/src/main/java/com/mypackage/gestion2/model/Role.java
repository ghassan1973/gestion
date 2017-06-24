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

import com.mypackage.gestion2.model.Permission;
import com.mypackage.gestion2.model.User;


@Entity
@Table(name="tbl_role")
public class Role {

//1748 RoleId PRIMARY_KEY $prop.getRelationshipType() false
//1749 RoleName TEXT $prop.getRelationshipType() true
//1753 Permissions REFERENCE MANY_TO_MANY true
//$prop.getId() Roles REFERENCE MANY_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Long roleId;

	@Column(name="role_name")
	    
    private String roleName;





	@ManyToMany
	@JoinTable(name = "tbl_role_permission_assoc",joinColumns={@JoinColumn(name="role_id")},
inverseJoinColumns={@JoinColumn(name="permission_id")})
	private List<Permission> permissions;

	
	/**
	*
	*/
	public Long getRoleId()
	{
		return this.roleId;
	}
	
	
	/**
	*
	*/
	public void setRoleId(Long _roleId)
	{
		this.roleId = _roleId;
	}
	/**
	*
	*/
	public String getRoleName()
	{
		return this.roleName;
	}
	
	
	/**
	*
	*/
	public void setRoleName(String _roleName)
	{
		this.roleName = _roleName;
	}


	/**
	*
	*/
	public List<Permission> getPermissions()
	{
		return this.permissions;
	}
	
	
	/**
	*
	*/
	public void setPermissions(List<Permission> _permissions)
	{
		this.permissions = _permissions;
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;

		if (roleId == null) {
			if (other.roleId != null)
				return false;
		}else if (!roleId.equals(other.roleId))
			return false;

				if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
				
		return true;
	}
}
