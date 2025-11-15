package br.com.eclass.eclass.cargo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICargoRepository extends JpaRepository<CargoModel, UUID> {
    
}
