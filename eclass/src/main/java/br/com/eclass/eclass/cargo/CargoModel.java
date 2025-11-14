package br.com.eclass.eclass.cargo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "cargo")
public class CargoModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;
    private String descricao;

}
