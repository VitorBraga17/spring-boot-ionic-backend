package com.bragavitor.cursospringb.services;

import java.util.Optional;

import com.bragavitor.cursospringb.domain.Cliente;
import com.bragavitor.cursospringb.repositories.ClienteRepository;
import com.bragavitor.cursospringb.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) { 
        Optional<Cliente> obj = repo.findById(id); 
       return obj.orElseThrow(() -> new ObjectNotFoundException( 
        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
       } 
}
