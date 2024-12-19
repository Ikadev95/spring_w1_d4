package com.epicode.spring_w1_d4.repository;

import com.epicode.spring_w1_d4.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaRepo extends JpaRepository<Pizza, Long> {
    List<Pizza> findByCalorieGreaterThanOrderByNome(int calorie);

    @Query("SELECT p FROM Pizza p WHERE p.nome = :nome")
    List<Pizza> trovaLePizzePerNome(String nome);

    List<Pizza> findByNomeContaining(String nome);
}
