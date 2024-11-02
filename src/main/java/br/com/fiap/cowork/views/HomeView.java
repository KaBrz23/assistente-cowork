package br.com.fiap.cowork.views;

import br.com.fiap.cowork.chat.ChatService;
import br.com.fiap.cowork.domain.ReservaService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Route("")
@Component
public class HomeView extends VerticalLayout {

    private final ReservaService reservaService;
    private final ChatService chatService;

    public HomeView(ReservaService reservaService, ChatService chatService) {

        add(new H1("Assistente de Cowork"));

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Chat", new ChatView(chatService));
        tabSheet.add("Reservas", new TableView(reservaService));

        tabSheet.setHeightFull();
        tabSheet.setWidthFull();

        setHeightFull();
        setWidthFull();


        add(tabSheet);
        this.reservaService = reservaService;
        this.chatService = chatService;
    }
}
