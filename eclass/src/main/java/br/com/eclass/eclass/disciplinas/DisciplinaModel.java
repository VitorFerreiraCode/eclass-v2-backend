package br.com.eclass.eclass.disciplinas;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "disciplina")
public class DisciplinaModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private String codigoDisciplina;
    private Integer ano;
    private Integer semestre;
    private boolean ativo;
    
    // private UUID curso;
    private UUID turma;
    private UUID professorResponsavel;

}
