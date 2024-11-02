package br.com.fiap.cowork.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findByMesa(String mesa);

    Reserva findByNome(String nome);
}
