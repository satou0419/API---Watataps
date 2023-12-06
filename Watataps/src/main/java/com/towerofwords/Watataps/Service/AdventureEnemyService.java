package com.towerofwords.Watataps.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.towerofwords.Watataps.Entity.AdventureEnemyEntity;
import com.towerofwords.Watataps.Repository.AdventureEnemyRepository;

@Service
public class AdventureEnemyService {
	
	@Autowired
	AdventureEnemyRepository aerepo;
	
	
	//C - read all records in tbladventure_ennemy
	public AdventureEnemyEntity insertAdventureEnemy(AdventureEnemyEntity enemy) {

		return aerepo.save(enemy);
	}
	
	//R - read all records in tbladventure_ennemy
	public List<AdventureEnemyEntity> getAllAdventureEnemy(){
		return aerepo.findAll();
	}
	
	//U - update enemy
	@SuppressWarnings("finally")
	public AdventureEnemyEntity updateAdventureEnemy(int enemyId, AdventureEnemyEntity newEnemyDetails) {
		AdventureEnemyEntity enemy = new AdventureEnemyEntity();
		
		
		try {
			//search
			enemy = aerepo.findById(enemyId).get();
			
			
			//Update
			enemy.setEnemyName(newEnemyDetails.getEnemyName());
			enemy.setWordId(newEnemyDetails.getWordId());
			enemy.setImagePath(newEnemyDetails.getImagePath());
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException ("enemy " + enemyId + " does not exist");
		}finally {
			return aerepo.save(enemy);
		}
	}
	
	//D - delete
	public String deleteEnemy(int enemyId) {
		String msg = "";
		
		if(aerepo.findById(enemyId) != null) {
			aerepo.deleteById(enemyId);
			msg = "Enemy " + enemyId + " is successfully deleted!";
		}else {
			msg = "Enemy " + enemyId +" does not exist";
		}
		
		
		return msg;
	}
}
