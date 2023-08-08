package com.example.bocadefumoapi.controllers;

import com.example.bocadefumoapi.dtos.DominioRecordDto;
import com.example.bocadefumoapi.models.DominioModel;
import com.example.bocadefumoapi.repositories.DominioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
