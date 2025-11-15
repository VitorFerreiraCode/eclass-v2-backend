package br.com.eclass.eclass.turma;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private ITurmaRepository turmaRepository;

    public TurmaModel criarTurma(TurmaModel turmaModel) {
        return turmaRepository.save(turmaModel);
    }

    public TurmaModel editarTurma(TurmaModel turmaModel) {
        return turmaRepository.save(turmaModel);
    }

    public void deletarTurma(UUID id) {
        turmaRepository.deleteById(id);
    }

    public TurmaModel obterTurmaPorId(UUID id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public List<TurmaModel> listarTurmas() {
        return (List<TurmaModel>) turmaRepository.findAll();
    }
    
}
