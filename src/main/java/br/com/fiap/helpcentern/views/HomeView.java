package br.com.fiap.helpcentern.views;

import br.com.fiap.helpcentern.chat.ChatService;
import br.com.fiap.helpcentern.domain.MatriculaService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Route("")
@Component
public class HomeView extends VerticalLayout {

    private final MatriculaService matriculaService;
    private final ChatService chatService;

    public HomeView(MatriculaService matriculaService, ChatService chatService) {

        add(new H1("Help Center FIAP"));

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Chat", new ChatView(chatService));
        tabSheet.add("Matrículas", new TableView(matriculaService));

        tabSheet.setHeightFull();
        tabSheet.setWidthFull();

        setHeightFull();
        setWidthFull();


        add(tabSheet);
        this.matriculaService = matriculaService;
        this.chatService = chatService;
    }
}
