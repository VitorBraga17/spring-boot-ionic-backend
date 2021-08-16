package com.bragavitor.cursospringb.repositories;

import com.bragavitor.cursospringb.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
     

}
