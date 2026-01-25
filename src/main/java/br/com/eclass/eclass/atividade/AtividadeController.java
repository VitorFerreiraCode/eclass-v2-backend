package br.com.eclass.eclass.atividade;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/criar")
    public ResponseEntity<AtividadeModel> criarAtividade(@RequestBody AtividadeModel atividadeModel) {
        AtividadeModel novaAtividade = atividadeService.criarAtividade(atividadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAtividade);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<AtividadeModel> editarAtividade(@PathVariable UUID id, @RequestBody AtividadeModel atividadeModel) {
        atividadeModel.setId(id);
        AtividadeModel atividadeAtualizada = atividadeService.editarAtividade(atividadeModel);
        return ResponseEntity.ok(atividadeAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAtividade(@PathVariable UUID id) {
        atividadeService.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<AtividadeModel> obterAtividadePorId(@PathVariable UUID id) {
        return atividadeService.obterAtividadePorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    public ResponseEntity<java.util.List<AtividadeModel>> listarAtividades() {
        java.util.List<AtividadeModel> atividades = atividadeService.listarAtividades();
        return ResponseEntity.ok(atividades);
    }

    

}
