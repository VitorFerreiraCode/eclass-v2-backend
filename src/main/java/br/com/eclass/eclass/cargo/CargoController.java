package br.com.eclass.eclass.cargo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoService cargoService;

    @PostMapping("/create")
    public ResponseEntity<?> criarCargo(@RequestBody CargoModel cargoModel) {
        CargoModel novoCargo = cargoService.criarCargo(cargoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCargo);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editarCargo(@PathVariable UUID id, @RequestBody CargoModel cargoModel) {
        cargoModel.setId(id);
        CargoModel cargoAtualizado = cargoService.editarCargo(cargoModel);
        return ResponseEntity.ok(cargoAtualizado);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarCargo(@PathVariable UUID id) {
        cargoService.deletarCargo(id);
        return ResponseEntity.ok("Cargo excluído: " + id);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CargoModel> obterCargoPorId(@PathVariable UUID id) {
        CargoModel cargo = cargoService.obterCargoPorId(id);
        return ResponseEntity.ok(cargo);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CargoModel>> listarCargos() {
        List<CargoModel> cargos = cargoService.listarCargos();
        return ResponseEntity.ok(cargos);
    }

    
}
