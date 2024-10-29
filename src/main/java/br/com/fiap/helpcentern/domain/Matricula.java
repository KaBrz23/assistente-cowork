package br.com.fiap.helpcentern.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Matricula {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String rm;
    String turma;
    String curso;
    @Enumerated(EnumType.STRING)
    StatusMatricula status;

}
