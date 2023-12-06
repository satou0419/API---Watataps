package com.towerofwords.Watataps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.towerofwords.Watataps.Entity.AdventureTowerEntity;


@Repository
public interface AdventureTowerRepository extends JpaRepository<AdventureTowerEntity, Integer>{

}
