package br.com.eclass.eclass.ecoins;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "ecoins")
public class EcoinsModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private int quantidade;



}
