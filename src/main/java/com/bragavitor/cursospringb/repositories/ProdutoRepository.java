package com.bragavitor.cursospringb.repositories;
import com.bragavitor.cursospringb.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
     

}
