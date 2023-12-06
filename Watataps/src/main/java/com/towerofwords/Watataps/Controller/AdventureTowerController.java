package com.towerofwords.Watataps.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.towerofwords.Watataps.Entity.AdventureTowerEntity;
import com.towerofwords.Watataps.Service.AdventureTowerService;


@RestController
@RequestMapping("/tower")
public class AdventureTowerController {
	@Autowired
	AdventureTowerService atserv;
	
	
	
	//C
	@PostMapping("/insertTower")
	public AdventureTowerEntity insertTower(@RequestBody AdventureTowerEntity tower) {
		return atserv.insertTower(tower);
	}
	
	//R
	@GetMapping("/getAllTower")
	public List<AdventureTowerEntity> getAllTower(){
		return atserv.getAllTower();
	}
	
	@GetMapping("/getTowerById")
	public Optional<AdventureTowerEntity> getTowerById(@RequestParam int towerId) {
		return atserv.getTowerById(towerId);
	}
	
	//U
	@PutMapping("/updateTower")
	public AdventureTowerEntity updateTower(@RequestParam int towerId, @RequestBody AdventureTowerEntity newTowerDetails) {
		return atserv.updateTower(towerId, newTowerDetails);
	}
	
	@DeleteMapping("deleteTower/{towerId}")
	public String deleteTower(@PathVariable int towerId) {
		return atserv.deleteTower(towerId);
	}
}
