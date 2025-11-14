package br.com.eclass.eclass.cargo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {
    
    @Autowired
    private ICargoRepository cargoRepository;

    public CargoModel criarCargo(CargoModel cargoModel) {
        return cargoRepository.save(cargoModel);
    }

    public CargoModel editarCargo(CargoModel cargoModel) {
        return cargoRepository.save(cargoModel);
    }

    public void deletarCargo(UUID id) {
        cargoRepository.deleteById(id);
    }

    public CargoModel obterCargoPorId(UUID id) {
        return cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cargo não encontrado."));
    }

    public List<CargoModel> listarCargos() {
        return cargoRepository.findAll();
    }

}
