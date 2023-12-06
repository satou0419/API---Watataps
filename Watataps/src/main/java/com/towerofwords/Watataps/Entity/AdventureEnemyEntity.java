package com.towerofwords.Watataps.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbladventure_enemy")
public class AdventureEnemyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enemyId;
	
	@Column(name = "enemy_name")
	private String enemyName;
	
	@Column(name = "word_id")
	private int wordId;
	
	@Column(name = "image_path")
	private String imagePath;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "tower_ref")
//	private AdventureTowerEntity tower;
//	@Column(name = "tower_ref")
//	private int towerRef;
	
	//Constructor

	public AdventureEnemyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdventureEnemyEntity(int enemyId, String enemyName, int wordId, String imagePath) {
		super();
		this.enemyId = enemyId;
		this.enemyName = enemyName;
		this.wordId = wordId;
		this.imagePath = imagePath;
		
	}

	//GET and SET
	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}



	public int getWordId() {
		return wordId;
	}



	public void setWordId(int wordId) {
		this.wordId = wordId;
	}



	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	
	

//	public int getTowerRef() {
//		return towerRef;
//	}
//
//	public void setTowerRef(int towerRef) {
//		this.towerRef = towerRef;
//	}
//	
	
	

	
}
