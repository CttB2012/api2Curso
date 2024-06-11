package com.curso.api2curso.controller;

import com.curso.api2curso.model.Possante;
import com.curso.api2curso.service.PossanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/curso/projeto2")
public class PossanteController {

    @Autowired
    private PossanteService _possanteService;

    @PostMapping("/cadastrnovopossante")
    public ResponseEntity<String> cadastrarPossante(@RequestBody Possante possante){

        String possanteCadastrado = _possanteService.cadastrarPossante(possante);
        return ResponseEntity.ok().body(possanteCadastrado);
    }

    @GetMapping("/listatodos")
    public ResponseEntity<List<Possante>> listarTodos(){

        List<Possante> lista = _possanteService.listarTodosPossantes();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/listapelaId/{id}")
    public ResponseEntity<Possante> listarPelaId(@PathVariable Long id) {

        Possante possanteId = _possanteService.listarPelaId(id);
        return ResponseEntity.ok().body(possanteId);
    }

    @DeleteMapping("/excluipossante/{id}")
    public ResponseEntity<Void> excluirPossante(@PathVariable Long id) {

        _possanteService.excluirPossante(id);
        return ResponseEntity.noContent().build();
    }
}
