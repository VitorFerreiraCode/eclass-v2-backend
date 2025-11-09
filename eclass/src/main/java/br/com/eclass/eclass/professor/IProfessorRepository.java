package br.com.eclass.eclass.professor;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessorRepository extends JpaRepository<ProfessorModel, UUID> {

    ProfessorModel findByEmail(String email);

}
