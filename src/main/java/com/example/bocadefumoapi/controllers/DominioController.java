package com.example.bocadefumoapi.controllers;

import com.example.bocadefumoapi.dtos.DominioRecordDto;
import com.example.bocadefumoapi.models.DominioModel;
import com.example.bocadefumoapi.repositories.DominioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class DominioController {

    @Autowired
    DominioRepository dominioRepo;

    @PostMapping("/dominios")
    public ResponseEntity<DominioModel> saveDominio(@RequestBody @Valid DominioRecordDto dominioBody){
        var dominioModel = new DominioModel();
        BeanUtils.copyProperties(dominioBody, dominioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(dominioRepo.save(dominioModel));
    }

    @GetMapping("/dominios")
    public ResponseEntity<List<DominioModel>> getAllDominio(){
        return ResponseEntity.status(HttpStatus.OK).body(dominioRepo.findAll());
    }

    @GetMapping("/dominios/{guidDominio}")
    public ResponseEntity<Object> getOneDominio(@PathVariable(value = "guidDominio") UUID guidDominio){
        Optional<DominioModel> dominio = dominioRepo.findById(guidDominio);
        if (dominio.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dominio não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(dominio.get());
    }

    @DeleteMapping("/dominios/{guidDominio}")
    public ResponseEntity<Object> deleteDominio(@PathVariable(value = "guidDominio") UUID guidDominio){
        Optional<DominioModel> dominio = dominioRepo.findById(guidDominio);

        if (dominio.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Dominio não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Doninio deletado.");
    }
}
