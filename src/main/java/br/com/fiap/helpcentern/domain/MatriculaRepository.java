package br.com.fiap.helpcentern.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    Matricula findByRm(String rm);

    Matricula findByNome(String nome);
}
