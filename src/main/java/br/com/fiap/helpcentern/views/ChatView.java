package br.com.fiap.helpcentern.views;

import br.com.fiap.helpcentern.chat.ChatService;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;

@Component
public class ChatView extends VerticalLayout {

    private final ChatService chatService;
    private MessageList messageList = new MessageList();
    private MessageInput messageInput = new MessageInput();

    public ChatView(ChatService chatService){

        addMessage("Olá, como posso ajudar?", "Help Center", true);

        messageList.setWidthFull();
        messageList.setHeightFull();
        messageInput.setWidthFull();

        setHeightFull();
        setWidthFull();

        messageInput.addSubmitListener(event -> send(event.getValue()));

        add(messageList, messageInput);
        this.chatService = chatService;
    }

    private void send(String message){
        addMessage(message, "Você", false);

        var response = chatService.sendToAi(message);
        addMessage(response, "Help Center", true);
    }


    private void addMessage(String message, String username, boolean isChatAssistent){
        var messageItem = new MessageListItem(
                message,
                Instant.now(),
                username,
                isChatAssistent ?
                        "https://avatar.iran.liara.run/public/job/operator/male" :
                        "https://avatar.iran.liara.run/public/job/doctor/male"
        );

        var messages = new ArrayList<>(messageList.getItems());
        messages.add(messageItem);
        messageList.setItems(messages);

    }

}
