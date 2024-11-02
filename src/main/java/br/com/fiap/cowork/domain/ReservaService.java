package br.com.fiap.cowork.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findAll(){
        return reservaRepository.findAll();
    }

    public Reserva findReserva(String mesa, String nome) {
        log.info("Buscando reserva da mesa {} e nome {}", mesa, nome);
        if (mesa != null){
            return reservaRepository.findByMesa(mesa);
        }

        return reservaRepository.findByNome(nome);
    }

    public Reserva cancelarReserva(String mesa, String nome) {
        log.info("Cancelando reserva da mesa {} e nome {}", mesa, nome);

        Reserva reserva;

        if (mesa != null){
            reserva = reservaRepository.findByMesa(mesa);
        }else{
            reserva = reservaRepository.findByNome(nome);
        }

        reserva.setStatus(StatusReserva.CANCELADA);
        return  reservaRepository.save(reserva);

    }

    public Reserva cadastrarReserva(String nome, String mesa, String data) {
        var matricula = Reserva.builder()
                .nome(nome)
                .data(data)
                .mesa(mesa)
                .status(StatusReserva.ATIVA)
                .build();

        return reservaRepository.save(matricula);
    }
}
