package br.com.eclass.eclass.ecoins;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcoinsService {
    
@Autowired
private IEcoinsRepository ecoinsRepository;

public EcoinsModel criarEcoins(EcoinsModel ecoinsModel) {
    return ecoinsRepository.save(ecoinsModel);
}

public EcoinsModel editarEcoins(EcoinsModel ecoinsModel) {
    return ecoinsRepository.save(ecoinsModel);
}

public void deletarEcoins(UUID id) {
    ecoinsRepository.deleteById(id);
}

public EcoinsModel obterEcoinsPorId(UUID id) {
    return ecoinsRepository.findById(id).orElseThrow(() -> new RuntimeException("Ecoins não encontrado."));
}

}
