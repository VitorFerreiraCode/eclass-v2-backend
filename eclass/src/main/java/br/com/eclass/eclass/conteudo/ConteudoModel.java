package br.com.eclass.eclass.conteudo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "conteudo")
public class ConteudoModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String titulo;
    private String descricao;
    private String dataFinal;
    
    private UUID disciplina;
    private UUID professor;



}
