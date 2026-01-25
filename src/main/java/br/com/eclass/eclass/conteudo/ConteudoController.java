package br.com.eclass.eclass.conteudo;

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
@RequestMapping("/conteudo")
public class ConteudoController {
    
    @Autowired
    private ConteudoService conteudoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarConteudo(@RequestBody ConteudoModel conteudoModel) {
        ConteudoModel novoConteudo = conteudoService.criarConteudo(conteudoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoConteudo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarConteudo(@PathVariable UUID id, @RequestBody ConteudoModel conteudoModel) {
        conteudoModel.setId(id);
        ConteudoModel conteudoAtualizado = conteudoService.editarConteudo(conteudoModel);
        return ResponseEntity.ok(conteudoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarConteudo(@PathVariable UUID id) {
        conteudoService.deletarConteudo(id);
        return ResponseEntity.ok("Conteúdo excluído: " + id);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ConteudoModel> obterConteudoPorId(@PathVariable UUID id) {
        ConteudoModel conteudo = conteudoService.obterConteudoPorId(id);
        return ResponseEntity.ok(conteudo);
    }

    @GetMapping("/listar")
    public ResponseEntity<java.util.List<ConteudoModel>> listarConteudos() {
        java.util.List<ConteudoModel> conteudos = conteudoService.listarConteudos();
        return ResponseEntity.ok(conteudos);
    }

}
