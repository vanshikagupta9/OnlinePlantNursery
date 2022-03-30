package com.cg.onlinenursery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "Planters")

public class Planters implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "planterId")
	// @GeneratedValue
	private Integer planterId;
	@Column(name = "planterHeight")
	private float planterHeight;
	@Column(name = "planterCapacity")
	private int planterCapacity;
	@Column(name = "planterdrinageHoles")
	private int planterdrinageHoles;
	@Column(name = "planterColor")
	private String planterColor;
	@Column(name = "planterShape")
	private String planterShape;
	@Column(name = "planterStock")
	private int planterStock;
	@Column(name = "planterCost")
	private int planterCost;

	// @JsonProperty(access=Access.READ_ONLY)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planter", targetEntity = Plants.class, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<Plants> plants;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planters", targetEntity = Seed.class, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Seed> seeds;
	
	public Planters() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Planters(Integer planterId, float planterHeight, int planterCapacity, int planterdrinageHoles,
			String planterColor, String planterShape, int planterStock, int planterCost, List<Plants> plants,
			List<Seed> seeds) {
		super();
		this.planterId = planterId;
		this.planterHeight = planterHeight;
		this.planterCapacity = planterCapacity;
		this.planterdrinageHoles = planterdrinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
		this.plants = plants;
		this.seeds = seeds;
	}



	public Integer getPlanterId() {
		return planterId;
	}

	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}

	public float getPlanterHeight() {
		return planterHeight;
	}

	public void setPlanterHeight(float planterHeight) {
		this.planterHeight = planterHeight;
	}

	public int getPlanterCapacity() {
		return planterCapacity;
	}

	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}

	public int getPlanterdrinageHoles() {
		return planterdrinageHoles;
	}

	public void setPlanterdrinageHoles(int planterdrinageHoles) {
		this.planterdrinageHoles = planterdrinageHoles;
	}

	public String getPlanterColor() {
		return planterColor;
	}

	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}

	public String getPlanterShape() {
		return planterShape;
	}

	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}

	public int getPlanterStock() {
		return planterStock;
	}

	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}

	public int getPlanterCost() {
		return planterCost;
	}

	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}

	public List<Plants> getPlants() {
		return plants;
	}

	public void setPlants(List<Plants> plants) {
		this.plants = plants;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}



	@Override
	public String toString() {
		return "Planters [planterId=" + planterId + ", planterHeight=" + planterHeight + ", planterCapacity="
				+ planterCapacity + ", planterdrinageHoles=" + planterdrinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ ", plants=" + plants + ", seeds=" + seeds + "]";
	}

	
	
	
}