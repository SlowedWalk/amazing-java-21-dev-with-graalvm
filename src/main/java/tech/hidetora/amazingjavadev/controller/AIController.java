//package tech.hidetora.amazingjavadev.controller;
//
//import org.springframework.ai.openai.OpenAiChatClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Map;
//
///**
// * @author hidetora
// * @version 1.0.0
// * @since 2022/04/18
// */
//@Controller
//@ResponseBody
//public class AIController {
//
//    private final OpenAiChatClient singularity;
//
//    public AIController(OpenAiChatClient singularity) {
//        this.singularity = singularity;
//    }
//
//    @GetMapping("/ai/story")
//    public Map<String, String> getStory() {
//        var prompt = """
//                You are a knight in the kingdom of Larion. You are hunting for a dangerous dragon that has been scaring the kingdom.
//                You enter the forest and find the dragon. You...
//                """;
//        var response = this.singularity.call(prompt);
//        return Map.of("story", response);
//    }
//}
