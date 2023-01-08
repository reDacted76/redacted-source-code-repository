import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarketOtcController {

    private static HttpResponse<String> getHttpOTCResponseBody(String apiRequest) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://otc.ftx.com/api"  + apiRequest))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    protected static String getAllOTCMarketData() throws IOException, InterruptedException {
        HttpResponse<String> response = getHttpOTCResponseBody("/currencies");
        return response.body();
    }

    protected static String getAllOTCTradingPairs() throws IOException, InterruptedException {
        HttpResponse<String> response = getHttpOTCResponseBody("/otc/pairs");
        return response.body();
    }
}
