package com.lucasgabriel.portifolio_api.services;

import com.lucasgabriel.portifolio_api.models.Projeto;
import com.lucasgabriel.portifolio_api.repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor // Injeção de dependência via construtor (Padrão Ouro)
@Slf4j
public class ProjetoService {

    // "final" garante imutabilidade e segurança
    private final ProjetoRepository repository;

    @Transactional
    public Projeto criar(Projeto projeto) {
        log.info("Iniciando criação de novo projeto: {}", projeto.getNome());
        return repository.save(projeto);
    }

    @Transactional
    public Projeto buscarPorId(Long id) {
        log.debug("Buscando projeto com ID: {}", id);

        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Projeto não encontrado com id: " + id
                ));
    }

    @Transactional
    public List<Projeto> listarTodos() {
        log.debug("Listando todos os projetos");
        return repository.findAll();
    }

    @Transactional
    public Projeto atualizar(Long id, Projeto projetoAtualizado) {
        log.info("Atualizando projeto ID: {}", id);

        Projeto projetoExistente = buscarPorId(id);

        projetoExistente.setNome(projetoAtualizado.getNome());
        projetoExistente.setDescricao(projetoAtualizado.getDescricao());
        projetoExistente.setTecnologias(projetoAtualizado.getTecnologias());
        projetoExistente.setUrlsImagem(projetoAtualizado.getUrlsImagem());

        return repository.save(projetoExistente);
    }

    @Transactional
    public void deletar(Long id) {
        log.info("Solicitação para deletar projeto ID: {}", id);

        Projeto projeto = buscarPorId(id);

        repository.delete(projeto);

        log.info("Projeto ID: {} deletado com sucesso", id);
    }

}