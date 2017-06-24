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
import javax.persistence.JoinTable;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Transient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import org.hibernate.validator.constraints.NotBlank;

import com.mypackage.gestion2.model.Role;







@Entity
@Table(name="tbl_user")
public class User implements UserDetails{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="user_id")
private Long userId;

@Column(name="first_name")

private String firstName;

@Column(name="last_name")

private String lastName;

@Column(name="email")

private String email;

@Column(name="password")

private String password;



@ManyToMany
@JoinTable(name = "tbl_user_role_assoc",joinColumns={@JoinColumn(name="user_id")},
inverseJoinColumns={@JoinColumn(name="role_id")})
private List<Role> roles;


/**
*
*/
public Long getUserId()
{
return this.userId;
}


/**
*
*/
public void setUserId(Long _userId)
{
this.userId = _userId;
}
/**
*
*/
public String getFirstName()
{
return this.firstName;
}


/**
*
*/
public void setFirstName(String _firstName)
{
this.firstName = _firstName;
}
/**
*
*/
public String getLastName()
{
return this.lastName;
}


/**
*
*/
public void setLastName(String _lastName)
{
this.lastName = _lastName;
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
public String getPassword()
{
return this.password;
}


/**
*
*/
public void setPassword(String _password)
{
this.password = _password;
}


/**
*
*/
public List<Role> getRoles()
{
return this.roles;
}


/**
*
*/
public void setRoles(List<Role> _roles)
{
this.roles = _roles;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
ArrayList<GrantedAuthority> arrayList = new ArrayList<GrantedAuthority>();
		arrayList.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "ROLE_USER";
			}
		});
		return arrayList;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

		@Transient
	public String getNaturalKey(){
		List<String> list = new ArrayList();
				list.add(this.getFirstName());
				list.add(this.getLastName());
				return StringUtils.join(list,",");
	}
	
	
	@Override
	public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;

		if (userId == null) {
			if (other.userId != null)
				return false;
		}else if (!userId.equals(other.userId))
			return false;

						if (getNaturalKey() == null) {
			if (other.getNaturalKey() != null)
				return false;
		} else if (!getNaturalKey().equals(other.getNaturalKey()))
			return false;
		
		return true;
	}
}
