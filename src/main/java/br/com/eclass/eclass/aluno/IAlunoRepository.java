package br.com.eclass.eclass.aluno;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunoRepository extends JpaRepository<AlunoModel, UUID> {

    AlunoModel findByEmail(String email);
    AlunoModel findByRa(String ra);
    

}



