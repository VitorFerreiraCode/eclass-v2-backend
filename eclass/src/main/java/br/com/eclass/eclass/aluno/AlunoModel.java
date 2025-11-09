package br.com.eclass.eclass.aluno;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity(name = "aluno")
public class AlunoModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String email;

    @Column(unique = true, nullable =  false)
    private String ra;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private String telefone;

    @Column(nullable = true)
    private String fotoUrl;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
}
