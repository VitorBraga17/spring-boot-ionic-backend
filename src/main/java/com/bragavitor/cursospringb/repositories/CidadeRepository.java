package com.bragavitor.cursospringb.repositories;
import com.bragavitor.cursospringb.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
     

}
