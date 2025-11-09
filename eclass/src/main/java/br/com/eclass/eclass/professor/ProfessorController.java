package br.com.eclass.eclass.professor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/professores")
public class ProfessorController {
    
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/create")
    public ResponseEntity<?> postMethodName(@RequestBody ProfessorModel professorModel) {
        try {
            var professorCriado = professorService.criarProfessor(professorModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(professorCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar professor");
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editProfessor(@RequestBody ProfessorModel professorModel) {
        try {
            var professorEditado = professorService.editarProfessor(professorModel);
            return ResponseEntity.ok(professorEditado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar professor");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable UUID id) {
        try {
            professorService.deletarProfessor(id);
            return ResponseEntity.ok("Professor deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar professor");
        }
    }

}
