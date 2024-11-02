package br.com.fiap.cowork.chat;

import br.com.fiap.cowork.domain.Reserva;
import br.com.fiap.cowork.domain.ReservaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.time.LocalDate;
import java.util.function.Function;

@Configuration
public class ChatTools {

    public record ReservaRequest(String mesa, String nome){}
    public record ReservaForm(String nome, String mesa, String data){}

    private final ReservaService reservaService;

    public ChatTools(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Bean
    @Description("Busca uma reserva por mesa ou por nome")
    public Function<ReservaRequest, Reserva> findReserva(){
        return request -> reservaService.findReserva(request.mesa, request.nome);
    }

    @Bean
    @Description("Cancelar Reserva")
    public Function<ReservaRequest, Reserva> cancelarReserva(){
        return request -> reservaService.cancelarReserva(request.mesa, request.nome);
    }

    @Bean
    @Description("Cadastrar reserva de mesa")
    public Function<ReservaForm, Reserva> cadastrarReserva(){
        return request -> reservaService.cadastrarReserva(request.nome, request.mesa, request.data);
    }

}
