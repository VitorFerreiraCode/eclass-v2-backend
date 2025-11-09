package br.com.eclass.eclass.avaliacao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {
    
    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping("/create")
    public ResponseEntity<?> criarAvaliacao(@RequestBody AvaliacaoModel avaliacaoModel) {
        AvaliacaoModel novaAvaliacao = avaliacaoService.criarAvaliacao(avaliacaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAvaliacao);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editarAvaliacao(@PathVariable UUID id, @RequestBody AvaliacaoModel avaliacaoModel) {
        avaliacaoModel.setId(id);
        AvaliacaoModel avaliacaoAtualizada = avaliacaoService.editarAvaliacao(avaliacaoModel);
        return ResponseEntity.ok(avaliacaoAtualizada);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarAvaliacao(@PathVariable UUID id) {
        avaliacaoService.deletarAvaliacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<AvaliacaoModel> obterAvaliacaoPorId(@PathVariable UUID id) {
        return avaliacaoService.obterAvaliacaoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

}
