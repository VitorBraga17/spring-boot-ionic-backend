package com.bragavitor.cursospringb.repositories;
import com.bragavitor.cursospringb.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
     

}
