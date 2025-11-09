package br.com.eclass.eclass.conteudo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IConteudoRepository extends JpaRepository<ConteudoModel, UUID> {
    
}
