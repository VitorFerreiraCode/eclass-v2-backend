package br.com.eclass.eclass.disciplina;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/disciplinas")
public class DisciplinaController {
    
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping("/create")
    public ResponseEntity<?> postMethodName(@RequestBody DisciplinaModel disciplinaModel) {
        try {
            var disciplinaCriada = disciplinaService.criarDisciplina(disciplinaModel);
            return ResponseEntity.status(201).body(disciplinaCriada);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao criar disciplina");
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editarDisciplina(@RequestBody DisciplinaModel disciplinaModel) {
        try {
            var disciplinaEditada = disciplinaService.editarDisciplina(disciplinaModel);
            return ResponseEntity.status(200).body(disciplinaEditada);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao editar disciplina");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarDisciplina(@PathVariable UUID id) {
        try {
            disciplinaService.deletarDisciplina(id);
            return ResponseEntity.status(200).body("Disciplina deletada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao deletar disciplina");
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<DisciplinaModel> obterDisciplinaPorId(@PathVariable UUID id) {
        DisciplinaModel disciplina = disciplinaService.obterDisciplinaPorId(id);
        if (disciplina != null) {
            return ResponseEntity.ok(disciplina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
