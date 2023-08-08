package com.example.bocadefumoapi.controllers;

import com.example.bocadefumoapi.dtos.ClienteRecordDto;
import com.example.bocadefumoapi.models.ClienteModel;
import com.example.bocadefumoapi.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepo;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteModel> saveCliente(@RequestBody @Valid ClienteRecordDto clienteBody){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteBody, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepo.save(clienteModel));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> getAllCliente(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepo.findAll());
    }

    @GetMapping("/clientes/{guid}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value = "guid") UUID guid){
        Optional<ClienteModel> clienteModel = clienteRepo.findById(guid);

        if (clienteModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModel.get());
    }

    @PutMapping("/clientes/{guid}")
    public ResponseEntity<Object> updateCliente(@PathVariable(value = "guid") UUID guid,
                                                @RequestBody @Valid ClienteRecordDto clienteBody){
        Optional<ClienteModel> cliente = clienteRepo.findById(guid);

        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        var clienteModel = cliente.get();
        BeanUtils.copyProperties(clienteBody, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepo.save(clienteModel));
    }
}
