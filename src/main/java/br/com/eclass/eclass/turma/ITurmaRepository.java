package br.com.eclass.eclass.turma;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurmaRepository extends JpaRepository<TurmaModel, UUID> {
    
}
