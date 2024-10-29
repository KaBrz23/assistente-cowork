package br.com.fiap.helpcentern.views;

import br.com.fiap.helpcentern.domain.Matricula;
import br.com.fiap.helpcentern.domain.MatriculaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class TableView extends VerticalLayout {

    private final MatriculaService matriculaService;
    private Grid<Matricula> grid = new Grid<>(Matricula.class);

    public TableView(MatriculaService matriculaService){

        grid.setColumns("id", "rm", "nome", "curso", "turma", "status" );
        grid.setEmptyStateText("nenhuma matrícula cadastrada atualmente");
        grid.setItems(matriculaService.findAll());

        add(grid);
        this.matriculaService = matriculaService;
    }

}
