package br.com.fiap.cowork.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Reserva {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;
    String data;
    String mesa;

    @Enumerated(EnumType.STRING)
    StatusReserva status;

}
