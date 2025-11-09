package br.com.eclass.eclass.conteudo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConteudoService {

    @Autowired
    private IConteudoRepository conteudoRepository;

    public ConteudoModel criarConteudo(ConteudoModel conteudoModel) {
        return conteudoRepository.save(conteudoModel);
    }

    public ConteudoModel editarConteudo(ConteudoModel conteudoModel) {
        return conteudoRepository.save(conteudoModel);
    }

    public void deletarConteudo(UUID id) {
        conteudoRepository.deleteById(id);
    }

    public ConteudoModel obterConteudoPorId(UUID id) {
        return conteudoRepository.findById(id).orElseThrow(() -> new RuntimeException("Conteúdo não encontrado."));
    }


}
