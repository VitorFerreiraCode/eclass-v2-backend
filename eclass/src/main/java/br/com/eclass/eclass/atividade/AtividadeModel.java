package br.com.eclass.eclass.atividade;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "atividade")
public class AtividadeModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String titulo;
    private String descricao;
    private String dataEntrega;
    private Integer notaMaxima;
    
    private UUID conteudo;
    private UUID disciplina;
    private UUID professor;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

}
