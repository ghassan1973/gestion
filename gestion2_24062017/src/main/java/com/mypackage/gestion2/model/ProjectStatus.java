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
@Table(name="tbl_project_status")
public class ProjectStatus {

//1770 ProjectStatusId PRIMARY_KEY $prop.getRelationshipType() true
//1771 ProjectStatusName TEXT $prop.getRelationshipType() true
//$prop.getId() Status REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_status_id")
	private Long projectStatusId;

	@Column(name="project_status_name")
	    
    private String projectStatusName;


	@OneToMany(mappedBy="projectStatus")
	private List<Project> status;




	
	/**
	*
	*/
	public Long getProjectStatusId()
	{
		return this.projectStatusId;
	}
	
	
	/**
	*
	*/
	public void setProjectStatusId(Long _projectStatusId)
	{
		this.projectStatusId = _projectStatusId;
	}
	/**
	*
	*/
	public String getProjectStatusName()
	{
		return this.projectStatusName;
	}
	
	
	/**
	*
	*/
	public void setProjectStatusName(String _projectStatusName)
	{
		this.projectStatusName = _projectStatusName;
	}

	/**
	*
	*/
	public List<Project> getStatus()
	{
		return this.status;
	}
	
	
	/**
	*
	*/
	public void setStatus(List<Project> _status)
	{
		this.status = _status;
	}



	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectStatus other = (ProjectStatus) obj;

		if (projectStatusId == null) {
			if (other.projectStatusId != null)
				return false;
		}else if (!projectStatusId.equals(other.projectStatusId))
			return false;

				if (projectStatusName == null) {
			if (other.projectStatusName != null)
				return false;
		} else if (!projectStatusName.equals(other.projectStatusName))
			return false;
				
		return true;
	}
}
