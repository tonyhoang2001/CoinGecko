package com.example.testcoin.repository;

import com.example.testcoin.model.CustomCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomCoinRepository extends JpaRepository<CustomCoin, Integer> {
}
