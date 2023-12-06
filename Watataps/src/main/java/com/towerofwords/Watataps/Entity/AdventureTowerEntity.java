package com.towerofwords.Watataps.Entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbladventure_tower")
public class AdventureTowerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "towerid")
	private int towerId;
	
	@Column(name = "tower")
	private String towerName;
	
	
	
//	@JoinColumn(name = "towerId", referencedColumnName = "tower_ref")
	@OneToMany(cascade = CascadeType.ALL)
	private List<AdventureEnemyEntity> enemyList;
	
	
	//Constructor
	public AdventureTowerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdventureTowerEntity(int towerId, String towerName, List<AdventureEnemyEntity> enemyList) {
		super();
		this.towerId = towerId;
		this.towerName = towerName;
		this.enemyList = enemyList;
	}


	public int getTowerId() {
		return towerId;
	}


	public void setTowerId(int towerId) {
		this.towerId = towerId;
	}


	public String getTowerName() {
		return towerName;
	}


	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}


	public List<AdventureEnemyEntity> getEnemyList() {
		return enemyList;
	}


	public void setEnemyList(List<AdventureEnemyEntity> enemyList) {
		this.enemyList = enemyList;
	}
	
	//get and set
	
	
	
	
	
	
}
