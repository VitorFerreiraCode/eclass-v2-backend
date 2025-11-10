package br.com.eclass.eclass.disciplina;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    private final IDisciplinaRepository disciplinaRepository;

    public DisciplinaService(IDisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public DisciplinaModel criarDisciplina(DisciplinaModel disciplinaModel) {

        if (disciplinaModel.getNome() == null || disciplinaModel.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome da disciplina não pode ser nulo ou vazio");
        }

        if (disciplinaModel.getCargaHoraria() == null || disciplinaModel.getCargaHoraria() <= 30) {
            throw new IllegalArgumentException("Carga horária deve ser um número positivo e maior que 30");
        }

        if (disciplinaModel.getAno() == null || disciplinaModel.getAno() < 2025) {
            throw new IllegalArgumentException("Ano deve ser válido");
        }

        if (disciplinaModel.getSemestre() == null || disciplinaModel.getSemestre() < 1 || disciplinaModel.getSemestre() > 2) {
            throw new IllegalArgumentException("Semestre deve ser 1 ou 2");
        }

        if (disciplinaModel.getTurma() == null) {
            throw new IllegalArgumentException("Turma não pode ser nulo");
        }

        if (disciplinaModel.getProfessorResponsavel() == null) {
            throw new IllegalArgumentException("Professor responsável não pode ser nulo");
        }

        return disciplinaRepository.save(disciplinaModel);
        
    }

    public DisciplinaModel editarDisciplina(DisciplinaModel disciplinaModel) {
        return disciplinaRepository.save(disciplinaModel);
    }

    public void deletarDisciplina(UUID id) {
        disciplinaRepository.deleteById(id);
    }

    public DisciplinaModel obterDisciplinaPorId(UUID id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

}
