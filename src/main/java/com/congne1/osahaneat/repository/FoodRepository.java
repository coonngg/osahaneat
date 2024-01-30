package com.congne1.osahaneat.repository;

import com.congne1.osahaneat.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
