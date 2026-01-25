package br.com.eclass.eclass.turma;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public TurmaModel criarTurma(@RequestBody TurmaModel turmaModel) {
        return turmaService.criarTurma(turmaModel);
    }

    @PutMapping("/editar/{id}")
    public TurmaModel editarTurma(@PathVariable UUID id, @RequestBody TurmaModel turmaModel) {
        return turmaService.editarTurma(turmaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTurma(@PathVariable UUID id) {
        turmaService.deletarTurma(id);
    }

    @GetMapping("/listar/{id}")
    public TurmaModel obterTurmaPorId(@PathVariable UUID id) {
        return turmaService.obterTurmaPorId(id);
    }

    @GetMapping("/listar")
    public List<TurmaModel> listarTurmas() {
        return turmaService.listarTurmas();
    }
    
}