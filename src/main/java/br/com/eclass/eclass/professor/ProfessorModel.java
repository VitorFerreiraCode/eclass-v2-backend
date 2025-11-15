package br.com.eclass.eclass.professor;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "professor")
public class ProfessorModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String email;
    private String senha;
    
    @Column(nullable = true)
    private String fotoUrl;

}
