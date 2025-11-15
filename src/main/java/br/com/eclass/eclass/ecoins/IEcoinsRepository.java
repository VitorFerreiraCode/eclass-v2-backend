package br.com.eclass.eclass.ecoins;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEcoinsRepository extends JpaRepository<EcoinsModel, UUID> {
    
}
