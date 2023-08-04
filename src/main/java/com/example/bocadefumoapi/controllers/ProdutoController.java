package com.example.bocadefumoapi.controllers;

import com.example.bocadefumoapi.dtos.ProdutoRecordDto;
import com.example.bocadefumoapi.models.ProdutoModel;
import com.example.bocadefumoapi.repositories.ProdutoRepository;
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
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepo;

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModel> saveProduto(@RequestBody @Valid ProdutoRecordDto produtoBody){
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoBody, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepo.save(produtoModel));
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModel>> getAllProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepo.findAll());
    }

    @GetMapping("/produtos/{guidProduto}")
    public ResponseEntity<Object> getOneProduto(@PathVariable(value = "guidProduto") UUID guid){
        Optional<ProdutoModel> produto = produtoRepo.findById(guid);
//        return produto.<ResponseEntity<Object>>map(produtoModel -> ResponseEntity.status(HttpStatus.OK).body(produtoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com guid {guid} não encontrado"));
        if(produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com guid {guid} não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    @PutMapping("/produtos/{guidProduto}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value = "guidProduto") UUID guid,
                                                      @RequestBody @Valid ProdutoRecordDto produtoBody){
        Optional<ProdutoModel> produto = produtoRepo.findById(guid);

        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto com guid {guid} não encontrado");
        }
        var produtoModel = produto.get();
        BeanUtils.copyProperties(produtoBody, produtoModel);
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepo.save(produtoModel));
    }

    @DeleteMapping("/produtos/{guidProduto}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "guidProduto") UUID guid){
        Optional<ProdutoModel> produto = produtoRepo.findById(guid);

        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        produtoRepo.delete(produto.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto deletado");
    }
}
