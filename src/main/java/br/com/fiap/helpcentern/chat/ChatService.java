package br.com.fiap.helpcentern.chat;

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
                            Você é um assitente virtual da secretaria da FIAP.
                            Você está conversando com alunos do ensino superior.
                            Seja cordial e divertido.
                            Tente manter o assunto dentro do contexto acadêmico.
                            Você pode usar chamada de funções para buscar dados de matrícula, trancar matricula e matricular aluno.
                            Antes de fornecer informações sobre matrícula ou trancar matricula, confirme o nome do aluno.
                            Só forneça essas informações se o nome corresponder.
                        """)
                .defaultFunctions("findMatricula", "trancarMatricula", "matricularAluno")
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
