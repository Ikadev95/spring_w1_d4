package com.epicode.spring_w1_d4.repository;

import com.epicode.spring_w1_d4.entity.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TavoloRepo extends JpaRepository<Tavolo, Long> {
}
