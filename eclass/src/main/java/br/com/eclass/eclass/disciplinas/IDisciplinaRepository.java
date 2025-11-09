package br.com.eclass.eclass.disciplinas;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplinaRepository extends JpaRepository<DisciplinaModel, UUID> {
    
    DisciplinaModel findByCodigoDisciplina(String codigoDisciplina);
    DisciplinaModel findByCargaHoraria(Integer cargaHoraria);
    DisciplinaModel findByNome(String nome);
    DisciplinaModel findByAno(Integer ano);
    DisciplinaModel findBySemestre(Integer semestre);
    DisciplinaModel findByAtivo(boolean ativo);
    DisciplinaModel findByTurma(UUID turma);
    DisciplinaModel findByProfessorResponsavel(UUID professorResponsavel);


}
