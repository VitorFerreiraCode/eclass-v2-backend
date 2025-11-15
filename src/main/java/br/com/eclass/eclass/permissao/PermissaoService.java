package br.com.eclass.eclass.permissao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {
    
@Autowired
private IPermissaoRepository permissaoRepository;

public PermissaoModel criarPermissao(PermissaoModel permissaoModel) {
    return permissaoRepository.save(permissaoModel);

}

public PermissaoModel editarPermissao(PermissaoModel permissaoModel) {
    return permissaoRepository.save(permissaoModel);
}

public void deletarPermissao(UUID id) {
    permissaoRepository.deleteById(id);
}

public PermissaoModel obterPermissaoPorId(UUID id) {
    return permissaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Permissão não encontrada."));
}

public List<PermissaoModel> listarPermissoes() {
    return permissaoRepository.findAll();
}


}
