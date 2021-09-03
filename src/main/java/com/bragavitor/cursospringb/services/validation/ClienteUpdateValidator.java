package com.bragavitor.cursospringb.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bragavitor.cursospringb.domain.Cliente;
import com.bragavitor.cursospringb.dto.ClienteDTO;
import com.bragavitor.cursospringb.repositories.ClienteRepository;
import com.bragavitor.cursospringb.resources.exceptions.FieldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;


public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);//Mapeando os Atributos da URI
        Integer uriId = Integer.parseInt(map.get("id"));//capturando a informação Id do map de atributos da URI

        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if(aux != null && !aux.getId().equals(uriId)){
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