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
@Table(name="tbl_project")
public class Project {

	//1772 ProjectId PRIMARY_KEY $prop.getRelationshipType() true
	//1773 ProjectName TEXT $prop.getRelationshipType() true
	//1775 Region REFERENCE MANY_TO_ONE true
	//1776 ProjectType REFERENCE MANY_TO_ONE true
	//1777 Status REFERENCE MANY_TO_ONE true
	//1778 StartDate DATE $prop.getRelationshipType() true
	//1779 EndDate DATE $prop.getRelationshipType() true
	//1780 Cost NUMBER $prop.getRelationshipType() true
	//1781 Sale NUMBER $prop.getRelationshipType() true
	//1782 RestToPay NUMBER $prop.getRelationshipType() true
	//1783 Margin NUMBER $prop.getRelationshipType() true
	//$prop.getId() Project REFERENCE ONE_TO_MANY true

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private Long projectId;

	@Column(name="project_name")

	private String projectName;

	@Column(name="start_date")

	private java.util.Date startDate;

	@Column(name="end_date")

	private java.util.Date endDate;

	@Column(name="cost")

	private Integer cost;

	@Column(name="sale")

	private Integer sale;

	@Column(name="rest_to_pay")

	private Integer restToPay;

	@Column(name="margin")

	private Integer margin;


	@OneToMany(mappedBy="project")
	private List<Order> project;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;
	@ManyToOne
	@JoinColumn(name = "project_type_id")
	private ProjectType projectType;
	@ManyToOne
	@JoinColumn(name = "project_status_id")
	private ProjectStatus projectStatus;




	/**
	 *
	 */
	public Long getProjectId()
	{
		return this.projectId;
	}


	/**
	 *
	 */
	public void setProjectId(Long _projectId)
	{
		this.projectId = _projectId;
	}
	/**
	 *
	 */
	public String getProjectName()
	{
		return this.projectName;
	}


	/**
	 *
	 */
	public void setProjectName(String _projectName)
	{
		this.projectName = _projectName;
	}
	/**
	 *
	 */
	public java.util.Date getStartDate()
	{
		return this.startDate;
	}


	/**
	 *
	 */
	public void setStartDate(java.util.Date _startDate)
	{
		this.startDate = _startDate;
	}
	/**
	 *
	 */
	public java.util.Date getEndDate()
	{
		return this.endDate;
	}


	/**
	 *
	 */
	public void setEndDate(java.util.Date _endDate)
	{
		this.endDate = _endDate;
	}
	/**
	 *
	 */
	public Integer getCost()
	{
		return this.cost;
	}


	/**
	 *
	 */
	public void setCost(Integer _cost)
	{
		this.cost = _cost;
	}
	/**
	 *
	 */
	public Integer getSale()
	{
		return this.sale;
	}


	/**
	 *
	 */
	public void setSale(Integer _sale)
	{
		this.sale = _sale;
	}
	/**
	 *
	 */
	public Integer getRestToPay()
	{
		return this.restToPay;
	}


	/**
	 *
	 */
	public void setRestToPay(Integer _restToPay)
	{
		this.restToPay = _restToPay;
	}
	/**
	 *
	 */
	public Integer getMargin()
	{
		return this.margin;
	}


	/**
	 *
	 */
	public void setMargin(Integer _margin)
	{
		this.margin = _margin;
	}

	/**
	 *
	 */
	public List<Order> getProject()
	{
		return this.project;
	}


	/**
	 *
	 */
	public void setProject(List<Order> _project)
	{
		this.project = _project;
	}


	/**
	 *
	 */
	public Region getRegion()
	{
		return this.region;
	}


	/**
	 *
	 */
	public void setRegion(Region _region)
	{
		this.region = _region;
	}
	/**
	 *
	 */
	public ProjectType getProjectType()
	{
		return this.projectType;
	}


	/**
	 *
	 */
	public void setProjectType(ProjectType _projectType)
	{
		this.projectType = _projectType;
	}
	/**
	 *
	 */
	public ProjectStatus getProjectStatus()
	{
		return this.projectStatus;
	}


	/**
	 *
	 */
	public void setProjectStatus(ProjectStatus _projectStatus)
	{
		this.projectStatus = _projectStatus;
	}
/*
	@Transient
	public String getNaturalKey(){
		List<String> list = new ArrayList();
		list.add(this.get${helper.asClassName($prop)}());
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
		Project other = (Project) obj;

		if (projectId == null) {
			if (other.projectId != null)
				return false;
		}else if (!projectId.equals(other.projectId))
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
