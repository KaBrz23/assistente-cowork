package br.com.fiap.helpcentern.chat;

import br.com.fiap.helpcentern.domain.Matricula;
import br.com.fiap.helpcentern.domain.MatriculaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class ChatTools {

    public record MatriculaRequest(String rm, String nome){}
    public record MatriculaForm(String nome, String curso){}

    private final MatriculaService matriculaService;

    public ChatTools(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @Bean
    @Description("Busca uma matricula por rm ou por nome")
    public Function<MatriculaRequest, Matricula> findMatricula(){
        return request -> matriculaService.findMatricula(request.rm, request.nome);
    }

    @Bean
    @Description("Trancar matrícula")
    public Function<MatriculaRequest, Matricula> trancarMatricula(){
        return request -> matriculaService.trancarMatricula(request.rm, request.nome);
    }

    @Bean
    @Description("Matricular aluno no curso")
    public Function<MatriculaForm, Matricula> matricularAluno(){
        return request -> matriculaService.matricularAluno(request.nome, request.curso);
    }

}
