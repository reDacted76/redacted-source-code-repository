//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.Instant;

public class BtcPull {

    public static void main(String[] args) throws IOException, InterruptedException {

        int pullNumber = 100000;

        int count = 0;

        while (pullNumber > 0) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ftx.us/api/markets/BTC/USD"))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            //System.out.println(response.body());
            JsonNode node = objectMapper.readTree(response.body());
            String name = node.get("result").get("name").asText();
            String price = node.get("result").get("price").asText();
            System.out.print(Timestamp.from(Instant.now()));
            System.out.print(" ");
            System.out.print(name);
            System.out.print(" ");
            System.out.print(price);
            System.out.print(" ");
            System.out.println("Count: " + count);
            count++;
            pullNumber--;
        }
    }
}
