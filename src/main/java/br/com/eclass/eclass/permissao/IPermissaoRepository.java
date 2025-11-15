package br.com.eclass.eclass.permissao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermissaoRepository extends JpaRepository<PermissaoModel, UUID> {

    
}
    