package br.com.eclass.eclass.professor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/criar")
    public ResponseEntity<?> postMethodName(@RequestBody ProfessorModel professorModel) {
        try {
            var professorCriado = professorService.criarProfessor(professorModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(professorCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar professor");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editProfessor(@PathVariable UUID id, @RequestBody ProfessorModel professorModel) {
        try {
            var professorEditado = professorService.editarProfessor(professorModel);
            return ResponseEntity.ok(professorEditado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar professor");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable UUID id) {
        try {
            professorService.deletarProfessor(id);
            return ResponseEntity.ok("Professor deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar professor");
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ProfessorModel> getById(@PathVariable UUID id) {
        ProfessorModel professor = professorService.obterProfessorPorId(id);
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/listar")
    public ResponseEntity<java.util.List<ProfessorModel>> listarProfessores() {
        java.util.List<ProfessorModel> professores = professorService.listarProfessores();
        return ResponseEntity.ok(professores);
    }

}
