package br.com.eclass.eclass.avaliacao;

import java.util.UUID;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private IAvaliacaoRepository avaliacaoRepository;

    public AvaliacaoModel criarAvaliacao(AvaliacaoModel avaliacaoModel) {
        return avaliacaoRepository.save(avaliacaoModel);
    }

    public AvaliacaoModel editarAvaliacao(AvaliacaoModel avaliacaoModel) {
        return avaliacaoRepository.save(avaliacaoModel);
    }

    public void deletarAvaliacao(UUID id) {
        avaliacaoRepository.deleteById(id);
    }

    public Optional<AvaliacaoModel> obterAvaliacaoPorId(UUID id) {
        return avaliacaoRepository.findById(id);
    }

    public java.util.List<AvaliacaoModel> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }


}
