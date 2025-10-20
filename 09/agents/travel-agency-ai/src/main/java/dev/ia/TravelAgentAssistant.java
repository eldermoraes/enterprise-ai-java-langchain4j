package dev.ia;

import io.quarkiverse.langchain4j.RegisterAiService;

// Esta anotação instrui o Quarkus a gerar uma implementação desta interface que se conecta ao LLM configurado.
@RegisterAiService
public interface TravelAgentAssistant {

    /**
     * O método 'chat' recebe a mensagem do usuário e retorna a resposta do LLM.
     * @param userMessage A mensagem do usuário.
     * @return A resposta gerada pelo modelo de linguagem.
     */
    String chat(String userMessage);
}