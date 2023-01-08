import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonMapping {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Http for json data from server
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ftx.us/api/markets/BTC/USD"))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //Json Object Handling
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readTree(response.body());
        String jsonText = node.get("result").get("name").asText();
        System.out.println(jsonText);

        //Set Http to new url
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://ftx.us/api/markets"))
                .GET()
                .build();
        HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
        System.out.println(response2.body());

        //Json array object handling
        node = objectMapper.readTree(response2.body());
        ArrayNode arrayNode = (ArrayNode) node.get("result");
        for (JsonNode n : arrayNode) {
            System.out.println(n.get("name").asText());
            System.out.println(n.get("last").asText());
            System.out.println(n.get("price").asText());
        }
    }
}
