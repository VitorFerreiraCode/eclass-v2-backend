package br.com.eclass.eclass.permissao;

import java.util.List;
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
@RequestMapping("/permissoes")
public class PermissaoController {
    
    @Autowired
    private PermissaoService permissaoService;

    @PostMapping("/create")
    public ResponseEntity<?> criarPermissao(@RequestBody PermissaoModel permissaoModel) {
        PermissaoModel novaPermissao = permissaoService.criarPermissao(permissaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPermissao);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editarPermissao(@PathVariable UUID id, @RequestBody PermissaoModel permissaoModel) {
        permissaoModel.setId(id);
        PermissaoModel permissaoAtualizada = permissaoService.editarPermissao(permissaoModel);
        return ResponseEntity.ok(permissaoAtualizada);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarPermissao(@PathVariable UUID id) {
        permissaoService.deletarPermissao(id);
        return ResponseEntity.ok("Permissão excluída: " + id);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<PermissaoModel> obterPermissaoPorId(@PathVariable UUID id) {
        PermissaoModel permissao = permissaoService.obterPermissaoPorId(id);
        return ResponseEntity.ok(permissao);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PermissaoModel>> listarPermissoes() {
        List<PermissaoModel> permissoes = permissaoService.listarPermissoes();
        return ResponseEntity.ok(permissoes);
    }

}
