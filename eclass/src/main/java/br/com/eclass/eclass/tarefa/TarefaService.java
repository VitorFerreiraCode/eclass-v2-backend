package br.com.eclass.eclass.tarefa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    
    @Autowired
    private ITarefaRepository tarefaRepository;

    public TarefaModel criarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    public TarefaModel editarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    public void deletarTarefa(UUID id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaModel obterTarefaPorId(UUID id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public List<TarefaModel> listarTarefas() {
        return (List<TarefaModel>) tarefaRepository.findAll();
    }

}
