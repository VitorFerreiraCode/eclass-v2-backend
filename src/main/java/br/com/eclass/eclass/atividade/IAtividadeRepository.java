package br.com.eclass.eclass.atividade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAtividadeRepository extends JpaRepository<AtividadeModel, java.util.UUID> {
    
}
