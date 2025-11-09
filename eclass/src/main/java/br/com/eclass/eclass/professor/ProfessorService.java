package br.com.eclass.eclass.professor;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private IProfessorRepository professorRepository;

    public ProfessorModel criarProfessor(ProfessorModel professorModel) {

        if (professorRepository.findByEmail(professorModel.getEmail()) != null) {
            throw new RuntimeException("Usuário com este email já existe.");
        }

        return professorRepository.save(professorModel);
    }

    public ProfessorModel editarProfessor(ProfessorModel professorModel) {
        return professorRepository.save(professorModel);
    }

    public void deletarProfessor(UUID id) {
        professorRepository.deleteById(id);
    }
    
}
