package com.bragavitor.cursospringb.repositories;
import com.bragavitor.cursospringb.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
     

}
