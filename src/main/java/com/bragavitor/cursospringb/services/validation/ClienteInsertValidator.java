package com.bragavitor.cursospringb.services.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bragavitor.cursospringb.domain.Cliente;
import com.bragavitor.cursospringb.domain.enums.TipoCliente;
import com.bragavitor.cursospringb.dto.ClienteNewDTO;
import com.bragavitor.cursospringb.repositories.ClienteRepository;
import com.bragavitor.cursospringb.resources.exceptions.FieldMessage;
import com.bragavitor.cursospringb.services.validation.utils.BR;

import org.springframework.beans.factory.annotation.Autowired;


public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

 @Autowired
 private ClienteRepository repo;

 @Override
 public void initialize(ClienteInsert ann) {
 }
 @Override
 public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
 List<FieldMessage> list = new ArrayList<>();
 
 if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
     list.add(new FieldMessage("cpfOuCnpj","CPF Invalido"));
 }

 if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
    list.add(new FieldMessage("cpfOuCnpj","CNPJ Invalido"));
}

Cliente aux = repo.findByEmail(objDto.getEmail());
if(aux != null){
    list.add(new FieldMessage("email","Email ja existente"));
}

 
for (FieldMessage e : list) {
 context.disableDefaultConstraintViolation();
 context.buildConstraintViolationWithTemplate(e.getMessage())
 .addPropertyNode(e.getFieldName()).addConstraintViolation();
 }
 return list.isEmpty();
 }
}