package com.validar.cliente.bs_validar_cliente.Endpoint;


import com.validar.cliente.bs_validar_cliente.DTO.ClienteDTO;
import com.validar.cliente.bs_validar_cliente.model.Cliente;
import com.validar.cliente.bs_validar_cliente.service.ValidarClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidarClienteController {


    ///////HELLO WORLD
    private ValidarClienteService validarClienteService;


    @Autowired
    public ValidarClienteController(ValidarClienteService validarClienteService){this.validarClienteService = validarClienteService; }

    @GetMapping("/method/{name}")
    public String method(@PathVariable String name){
        System.out.println("Hi " + name + ", it is working on port 8181");
      //  ClienteDTO cliente = new ClienteDTO();
      //  validarClienteService.registerCliente(cliente.s);
        return name;
    }



}
