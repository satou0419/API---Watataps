package com.towerofwords.Watataps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.towerofwords.Watataps.Entity.AdventureEnemyEntity;


@Repository
public interface AdventureEnemyRepository extends JpaRepository<AdventureEnemyEntity, Integer> {
	
}
