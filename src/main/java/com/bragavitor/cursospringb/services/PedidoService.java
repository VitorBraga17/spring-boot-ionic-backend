package com.bragavitor.cursospringb.services;

import java.util.Optional;

import com.bragavitor.cursospringb.domain.Pedido;
import com.bragavitor.cursospringb.repositories.PedidoRepository;
import com.bragavitor.cursospringb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) { 
        Optional<Pedido> obj = repo.findById(id); 
       return obj.orElseThrow(() -> new ObjectNotFoundException( 
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
       } 
}
