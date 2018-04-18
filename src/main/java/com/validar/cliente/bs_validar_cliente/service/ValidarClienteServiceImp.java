package com.validar.cliente.bs_validar_cliente.service;

import com.validar.cliente.bs_validar_cliente.DTO.ClienteDTO;
import com.validar.cliente.bs_validar_cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ValidarClienteServiceImp implements ValidarClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String registerCliente(ClienteDTO clienteDTO) {
       // restTemplate.postForEntity(,"jkasdbas",String.class);
        System.out.println("client registered in Validar cliente service implementation");
        return null;
    }




}
