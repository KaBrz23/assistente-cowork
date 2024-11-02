package br.com.fiap.cowork.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                            Você é um assistente virtual de um espaço de coworking.
                            Está conversando com clientes que desejam reservar, consultar ou cancelar a reserva de uma mesa ou sala de reunião.
                            Seja profissional e receptivo, ajudando os clientes a agendar seu espaço de trabalho.
                            Utilize chamada de funções para consultar reservas, cadastrar novas reservas e cancelar reservas.
                            Antes de fornecer detalhes de reservas ou realizar cancelamentos, confirme o nome e o número da reserva do cliente.
                            Somente execute a ação se as informações corresponderem.
                        """)
                .defaultFunctions("findReserva", "cadastrarReserva", "cancelarReserva")
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }

    public String sendToAi(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }

}
