package com.towerofwords.Watataps.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.towerofwords.Watataps.Entity.AdventureTowerEntity;
import com.towerofwords.Watataps.Repository.AdventureTowerRepository;

@Service
public class AdventureTowerService {
	
	@Autowired
	AdventureTowerRepository atrepo;
	
	//C
	public AdventureTowerEntity insertTower(AdventureTowerEntity tower) {
		return atrepo.save(tower);
	}
	
	
	//R
	
	public List<AdventureTowerEntity> getAllTower(){
		return atrepo.findAll();
	}
	
	public Optional<AdventureTowerEntity> getTowerById(int towerId) {
		return atrepo.findById(towerId);
	}
	
	//U
	
	@SuppressWarnings("finally")
	public AdventureTowerEntity updateTower(int towerId, AdventureTowerEntity newTowerDetails) {
		AdventureTowerEntity tower = new AdventureTowerEntity();
		
		try {
			//search
			tower = atrepo.findById(towerId).get();
			
			//Update
			tower.setTowerName(newTowerDetails.getTowerName());
			tower.setEnemyList(newTowerDetails.getEnemyList());
			
			
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException ("Tower " + towerId + " does not exist");
		}finally {
			return atrepo.save(tower);
		}
	}
	
	//D
	
	public String deleteTower(int towerId) {
		String msg ="";
		
		if(atrepo.findById(towerId) != null) {
			atrepo.deleteById(towerId);
			msg = "Tower " + towerId + " is successfully deleted!";
		}else {
			msg = "Tower " + towerId + " does not exist";
		}
		
		return msg;
	}
	
}
