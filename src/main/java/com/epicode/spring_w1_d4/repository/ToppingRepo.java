package com.epicode.spring_w1_d4.repository;

import com.epicode.spring_w1_d4.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepo extends JpaRepository <Topping, Long> {
}
