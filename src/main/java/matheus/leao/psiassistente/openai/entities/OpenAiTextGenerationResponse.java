package matheus.leao.psiassistente.openai.entities;

import java.util.List;

public class OpenAiTextGenerationResponse {
    String id;
    String object;
    String model;
    public List<Choice> choices;
}


