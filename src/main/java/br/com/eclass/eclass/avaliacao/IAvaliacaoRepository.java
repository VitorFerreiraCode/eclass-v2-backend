package br.com.eclass.eclass.avaliacao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacaoRepository extends JpaRepository<AvaliacaoModel, UUID> {

}
