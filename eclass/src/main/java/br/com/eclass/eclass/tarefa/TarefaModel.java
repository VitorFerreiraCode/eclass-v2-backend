package br.com.eclass.eclass.tarefa;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tarefa")
public class TarefaModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String titulo;
    private String descricao;
    private String dataEntrega;

    private UUID conteudo;
    private UUID disciplina;
    private UUID professor;

}
