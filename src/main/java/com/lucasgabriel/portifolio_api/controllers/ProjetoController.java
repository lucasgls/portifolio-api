package com.lucasgabriel.portifolio_api.controllers;

import com.lucasgabriel.portifolio_api.models.Projeto;
import com.lucasgabriel.portifolio_api.services.ProjetoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody @Valid Projeto projeto) {
        log.info("Recebendo requisição para criar projeto: {}", projeto.getNome());

        Projeto novoProjeto = service.criar(projeto);

        return ResponseEntity.ok(novoProjeto);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listar() {
        log.info("Recebendo requisição para listar todos os projetos");
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
        log.info("Recebendo requisição para buscar projeto ID: {}", id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody @Valid Projeto projeto) {
        log.info("Recebendo requisição para atualizar projeto ID: {}", id);

        Projeto projetoAtualizado = service.atualizar(id, projeto);

        return ResponseEntity.ok(projetoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Recebendo requisição para deletar projeto ID: {}", id);

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}