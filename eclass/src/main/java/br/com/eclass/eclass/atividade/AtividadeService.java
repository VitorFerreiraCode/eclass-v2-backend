package br.com.eclass.eclass.atividade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {
    
    @Autowired
    private IAtividadeRepository atividadeRepository;

    public AtividadeModel criarAtividade(AtividadeModel atividadeModel) {
        return atividadeRepository.save(atividadeModel);
    }

    public AtividadeModel editarAtividade(AtividadeModel atividadeModel) {
        return atividadeRepository.save(atividadeModel);
    }

    public void deletarAtividade(java.util.UUID id) {
        atividadeRepository.deleteById(id);
    }

    public java.util.Optional<AtividadeModel> obterAtividadePorId(java.util.UUID id) {
        return atividadeRepository.findById(id);
    }

}
