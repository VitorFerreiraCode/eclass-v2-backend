package br.com.eclass.eclass.ecoins;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ecoin")
public class EcoinsController {
    
    @Autowired
    private EcoinsService ecoinsService;

    @PostMapping("/criar")
    public EcoinsModel criarEcoins(@RequestBody EcoinsModel ecoinsModel) {
        return ecoinsService.criarEcoins(ecoinsModel);
    }

    @PutMapping("/editar/{id}")
    public EcoinsModel editarEcoins(@PathVariable UUID id, @RequestBody EcoinsModel ecoinsModel) {
        ecoinsModel.setId(id);
        return ecoinsService.editarEcoins(ecoinsModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarEcoins(@PathVariable UUID id) {
        ecoinsService.deletarEcoins(id);
    }

    @GetMapping("/listar/{id}")
    public EcoinsModel obterEcoinsPorId(@PathVariable UUID id) {
        return ecoinsService.obterEcoinsPorId(id);
    }

}
