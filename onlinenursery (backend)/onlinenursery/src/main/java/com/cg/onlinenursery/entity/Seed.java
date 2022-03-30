package com.cg.onlinenursery.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "Seed")
public class Seed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "seedId")
	// @GeneratedValue
	private int seedId;
	@Column(name = "commonName")
	private String commonName;
	@Column(name = "bloomTime")
	private String bloomTime;
	@Column(name = "difficultyLevel")
	private String difficultyLevel;
	@Column(name = "seedsCost")
	private Integer seedsCost;
	@Column(name = "seedsDescription")
	private String seedsDescription;
	@Column(name = "seedsPerPacket")
	private Integer seedsPerPacket;
    @Column(name = "seedsStock")
	private Integer seedsStock;
	@Column(name = "temparature")
	private int temparature;
	@Column(name = "typeOfSeeds")
	private String typeOfSeeds;
    @Column(name = "watering")
	private String watering;

    
	@JsonProperty(access = Access.READ_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plantersid")
	private Planters planters;

	public Seed() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getSeedsCost() {
		return seedsCost;
	}


	public void setSeedsCost(Integer seedsCost) {
		this.seedsCost = seedsCost;
	}


	public int getSeedId() {
		return seedId;
	}

	public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public int getTemparature() {
		return temparature;
	}

	public void setTemparature(int temparature) {
		this.temparature = temparature;
	}

	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}

	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}

	public String getSeedsDescription() {
		return seedsDescription;
	}

	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}

	public Integer getSeedsStock() {
		return seedsStock;
	}

	public void setSeedsStock(Integer seedsStock) {
		this.seedsStock = seedsStock;
	}

	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

	public Planters getPlanters() {
		return planters;
	}

	public void setPlanters(Planters planters) {
		this.planters = planters;
	}

	public Seed(int seedId, String commonName, String bloomTime, String watering, String difficultyLevel,
			int temparature, String typeOfSeeds, String seedsDescription, Integer seedsStock, Integer seedsPerPacket,
			Planters planters) {
		super();
		this.seedId = seedId;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temparature = temparature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsPerPacket = seedsPerPacket;
		this.planters = planters;
	}


	@Override
	public String toString() {
		return "Seed [seedId=" + seedId + ", commonName=" + commonName + ", bloomTime=" + bloomTime
				+ ", difficultyLevel=" + difficultyLevel + ", seedsCost=" + seedsCost + ", seedsDescription="
				+ seedsDescription + ", seedsPerPacket=" + seedsPerPacket + ", seedsStock=" + seedsStock
				+ ", temparature=" + temparature + ", typeOfSeeds=" + typeOfSeeds + ", watering=" + watering
				+ ", planters=" + planters + "]";
	}
	
}