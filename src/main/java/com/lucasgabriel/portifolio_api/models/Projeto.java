package com.lucasgabriel.portifolio_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projetos")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do projeto não pode estar vazio")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @NotBlank(message = "Liste as tecnologias utilizadas")
    @Column(nullable = false)
    private String tecnologias;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    @Builder.Default
    private List<String> urlsImagem = new ArrayList<>();

}
