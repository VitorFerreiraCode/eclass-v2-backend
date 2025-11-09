package br.com.eclass.eclass.aluno;

import java.util.UUID;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AlunoService {
    @Autowired
    private IAlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel alunoModel) {

        // Verificações de duplicidade
        if (alunoRepository.findByEmail(alunoModel.getEmail()) != null) {
            throw new RuntimeException("Usuário com este email já existe.");
        }

        if (alunoRepository.findByRa(alunoModel.getRa()) != null) {
            throw new RuntimeException("Usuário com este RA já existe.");
        }

    var passwordHashed = BCrypt.withDefaults().hashToString(12, alunoModel.getSenha().toCharArray());
        alunoModel.setSenha(passwordHashed);

        return alunoRepository.save(alunoModel);
    }

    public AlunoModel editarAluno(AlunoModel alunoModel) {

        if (alunoModel.getSenha() != null && !alunoModel.getSenha().isEmpty()) {
            var passwordHashed = BCrypt.withDefaults().hashToString(12, alunoModel.getSenha().toCharArray());
            alunoModel.setSenha(passwordHashed);
        } else {
            var alunoExistente = alunoRepository.findById(alunoModel.getId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado para edição."));
            alunoModel.setSenha(alunoExistente.getSenha());
        }

        if (alunoRepository.findByEmail(alunoModel.getEmail()) != null) {
            var alunoComMesmoEmail = alunoRepository.findByEmail(alunoModel.getEmail());
            if (!alunoComMesmoEmail.getId().equals(alunoModel.getId())) {
                throw new RuntimeException("Usuário com este email já existe.");
            }
        }

        return alunoRepository.save(alunoModel);
    }

    public void deletarAluno(UUID id) {
        alunoRepository.deleteById(id);
    }

    public Optional<AlunoModel> obterAlunoPorId(UUID id) {
        return alunoRepository.findById(id);
    }

    public List<AlunoModel> obterTodos() {
        return alunoRepository.findAll();
    }
}
