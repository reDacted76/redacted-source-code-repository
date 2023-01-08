import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.net.http.HttpResponse;

import static MarketController.getHistory;
import static MarketController.getMarketData;

public class MarketService {

    private static JsonNode createJsonNodeMapping(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(response.body());
        return objectMapper.readTree(response.body());
    }

    public static String checkResponseStatus(HttpResponse<String> response) throws JsonProcessingException {
        JsonNode node = createJsonNodeMapping(response);
        return node.get("success").asText();
    }

    public static  void showCandlesFor(String coin) throws IOException, InterruptedException {
        JsonNode node = createJsonNodeMapping(getHistory(coin));
        ArrayNode arrayNode = (ArrayNode) node.get("result");
        System.out.println("Result for: " + coin);
        for (JsonNode n : arrayNode) {
            System.out.print(n.get("time").asLong());
            System.out.print(" ");
            System.out.print(n.get("open").asDouble());
            System.out.print(" ");
            System.out.print(n.get("high").asDouble());
            System.out.print(" ");
            System.out.print(n.get("low").asDouble());
            System.out.print(" ");
            System.out.print(n.get("close").asDouble());
            System.out.print(" ");
            System.out.println(n.get("volume").asDouble());
        }
    }

    public static JsonNode getQuoteFor(String coin) throws IOException, InterruptedException {
        JsonNode node = createJsonNodeMapping(getMarketData(coin));
        return node.get("result");
    }

    public static  ArrayNode getCandlesFor(String coin) throws IOException, InterruptedException {
        JsonNode node = createJsonNodeMapping(getHistory(coin));
        return (ArrayNode) node.get("result");
    }
}
