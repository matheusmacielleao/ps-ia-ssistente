package matheus.leao.psiassistente.openai;


import matheus.leao.psiassistente.openai.entities.OpenAiTextGenerationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class OpenAiService {
    private final RestTemplate restTemplate;
    @Value("${openai.api-key}")
    private final String apiKey;

    public OpenAiService(@Value("${openai.api-key}") String apiKey){
        this.apiKey = apiKey;
        this.restTemplate = new RestTemplate();
    }

    public String getAnswer(String question){
        String url = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + this.apiKey);
        headers.set("Content-Type", "application/json");

        String payload = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + question + "\"}]}";
        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<OpenAiTextGenerationResponse> response = restTemplate.postForEntity(url, entity, OpenAiTextGenerationResponse.class);
        return Objects.requireNonNull(response.getBody()).choices.get(0).message.content;
    }
}
