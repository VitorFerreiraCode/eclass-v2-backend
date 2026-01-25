package br.com.eclass.eclass.tarefa;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/criar")
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel) {
        TarefaModel novaTarefa = tarefaService.criarTarefa(tarefaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<TarefaModel> editarTarefa(@PathVariable UUID id, @RequestBody TarefaModel tarefaModel) {
        tarefaModel.setId(id);
        TarefaModel tarefaAtualizada = tarefaService.editarTarefa(tarefaModel);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable UUID id) {
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<TarefaModel> obterTarefaPorId(@PathVariable UUID id) {
        TarefaModel tarefa = tarefaService.obterTarefaPorId(id);
        if (tarefa != null) {
            return ResponseEntity.ok(tarefa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }       

    @GetMapping("/listar")
    public ResponseEntity<java.util.List<TarefaModel>> listarTarefas() {
        java.util.List<TarefaModel> tarefas = tarefaService.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

}
