package br.com.fiap.helpcentern.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public List<Matricula> findAll(){
        return matriculaRepository.findAll();
    }

    public Matricula findMatricula(String rm, String nome) {
        log.info("Buscando matricula rm {} e nome {}", rm, nome);
        if (rm != null){
            return matriculaRepository.findByRm(rm);
        }

        return matriculaRepository.findByNome(nome);
    }

    public Matricula trancarMatricula(String rm, String nome) {
        log.info("Trancando matricula rm {} e nome {}", rm, nome);

        Matricula matricula;

        if (rm != null){
            matricula = matriculaRepository.findByRm(rm);
        }else{
            matricula = matriculaRepository.findByNome(nome);
        }

        matricula.setStatus(StatusMatricula.TRANCADA);
        return  matriculaRepository.save(matricula);

    }

    public Matricula matricularAluno(String nome, String curso) {
        var matricula = Matricula.builder()
                .nome(nome)
                .curso(curso)
                .turma("Turma A")
                .rm("RM00111")
                .status(StatusMatricula.ATIVA)
                .build();

        return matriculaRepository.save(matricula);
    }
}
