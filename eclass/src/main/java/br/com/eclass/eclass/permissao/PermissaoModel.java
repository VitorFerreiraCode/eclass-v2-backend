package br.com.eclass.eclass.permissao;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "permissoes")
public class PermissaoModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String descricao;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean ativo;

}
