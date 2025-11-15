package br.com.eclass.eclass.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITarefaRepository extends JpaRepository<TarefaModel, java.util.UUID> {
    
}
