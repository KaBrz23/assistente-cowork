package br.com.fiap.cowork.views;

import br.com.fiap.cowork.domain.Reserva;
import br.com.fiap.cowork.domain.ReservaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

@Component
public class TableView extends VerticalLayout {

    private final ReservaService reservaService;
    private Grid<Reserva> grid = new Grid<>(Reserva.class);

    public TableView(ReservaService reservaService){

        grid.setColumns("id", "nome", "data", "mesa", "status" );
        grid.setEmptyStateText("nenhuma reserva cadastrada atualmente");
        grid.setItems(reservaService.findAll());

        add(grid);
        this.reservaService = reservaService;
    }

}
