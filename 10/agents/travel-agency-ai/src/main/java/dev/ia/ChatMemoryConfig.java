package dev.ia;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ChatMemoryConfig {

    // Produz um bean de ChatMemory para cada nova sessão de chat.
    @Produces
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                .maxMessages(20) // Mantém as últimas 20 mensagens na memória
                .chatMemoryStore(new InMemoryChatMemoryStore())
                .build();
    }
}