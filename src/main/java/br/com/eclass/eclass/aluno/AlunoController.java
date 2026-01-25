package br.com.eclass.eclass.aluno;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @PostMapping("/criar")
    public ResponseEntity<?> postMethodName(@RequestBody AlunoModel alunoModel) {
        try {
            var alunoCriado = alunoService.criarAluno(alunoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar aluno");
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editAluno(@RequestBody AlunoModel alunoModel) {
        try {
            var alunoEditado = alunoService.editarAluno(alunoModel);
            return ResponseEntity.ok(alunoEditado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao editar aluno");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable UUID id) {
        try {
            alunoService.deletarAluno(id);
            return ResponseEntity.ok("Aluno deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar aluno");
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<AlunoModel> getById(@PathVariable UUID id) {
        return alunoService.obterAlunoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<AlunoModel>> getAll() {
        var alunos = alunoService.obterTodos();
        return ResponseEntity.ok(alunos);
    }
    
}
