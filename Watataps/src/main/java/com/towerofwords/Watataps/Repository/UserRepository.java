package com.towerofwords.Watataps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.towerofwords.Watataps.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
