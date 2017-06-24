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
@Table(name="tbl_project_type")
public class ProjectType {

//1764 ProjectTypeId PRIMARY_KEY $prop.getRelationshipType() true
//1765 ProjectTypeName TEXT $prop.getRelationshipType() true
//$prop.getId() ProjectType REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_type_id")
	private Long projectTypeId;

	@Column(name="project_type_name")
	    
    private String projectTypeName;


	@OneToMany(mappedBy="projectType")
	private List<Project> projectType;




	
	/**
	*
	*/
	public Long getProjectTypeId()
	{
		return this.projectTypeId;
	}
	
	
	/**
	*
	*/
	public void setProjectTypeId(Long _projectTypeId)
	{
		this.projectTypeId = _projectTypeId;
	}
	/**
	*
	*/
	public String getProjectTypeName()
	{
		return this.projectTypeName;
	}
	
	
	/**
	*
	*/
	public void setProjectTypeName(String _projectTypeName)
	{
		this.projectTypeName = _projectTypeName;
	}

	/**
	*
	*/
	public List<Project> getProjectType()
	{
		return this.projectType;
	}
	
	
	/**
	*
	*/
	public void setProjectType(List<Project> _projectType)
	{
		this.projectType = _projectType;
	}



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectType other = (ProjectType) obj;

		if (projectTypeId == null) {
			if (other.projectTypeId != null)
				return false;
		}else if (!projectTypeId.equals(other.projectTypeId))
			return false;

				if (projectTypeName == null) {
			if (other.projectTypeName != null)
				return false;
		} else if (!projectTypeName.equals(other.projectTypeName))
			return false;
				
		return true;
	}
}
