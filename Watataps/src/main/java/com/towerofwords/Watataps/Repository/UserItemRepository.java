package com.towerofwords.Watataps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.towerofwords.Watataps.Entity.UserItemEntity;

public interface UserItemRepository extends JpaRepository<UserItemEntity, Integer> {
}
