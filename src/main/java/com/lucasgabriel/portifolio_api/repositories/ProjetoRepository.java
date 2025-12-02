package com.lucasgabriel.portifolio_api.repositories;

import com.lucasgabriel.portifolio_api.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    List<Projeto> id(Long id);
}
