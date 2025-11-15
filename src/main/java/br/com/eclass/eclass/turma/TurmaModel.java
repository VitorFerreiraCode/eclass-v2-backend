package br.com.eclass.eclass.turma;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "turmas")
public class TurmaModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String descricao;
    private Integer ano;
    private Integer semestre;
    private String codigoTurma;
    private boolean ativo;
    
}
