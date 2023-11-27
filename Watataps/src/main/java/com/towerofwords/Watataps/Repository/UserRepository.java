package com.towerofwords.Watataps.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.towerofwords.Watataps.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
