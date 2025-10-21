package dev.ia;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

// A anotação agora inclui a referência à nossa classe de Tools
@RegisterAiService(tools = BookingTools.class)
public interface PackageExpert {

    @SystemMessage("""
        Você é um assistente virtual da 'Mundo Viagens', um especialista em nossos pacotes de viagem e reservas.
        Sua principal responsabilidade é responder às perguntas dos clientes de forma amigável e precisa,
        baseando-se exclusivamente nas informações contidas nos documentos que lhe foram fornecidos (RAG)
        ou utilizando as ferramentas disponíveis para interagir com o sistema de reservas.
        Nunca invente informações ou use conhecimento externo.
        Se a resposta para uma pergunta não estiver nos documentos e nenhuma ferramenta puder ajudar,
        você deve responder educadamente:
        'Desculpe, mas não tenho informações sobre isso. Posso ajudar com mais alguma dúvida sobre nossos pacotes?'
        """)
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}