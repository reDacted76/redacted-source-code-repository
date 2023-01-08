import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarketController {

    private static HttpResponse<String> getHttpResponseBody(String apiRequest) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ftx.us/api/markets" + apiRequest))
                .GET()
                .build();
        HttpClient client = HttpClient.newBuilder().build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

//    public static String getAllMarketData() throws IOException, InterruptedException {
//        HttpResponse<String> response = getHttpResponseBody("");
//        return response.body();
//    }

    public static  HttpResponse<String> getAllMarketData() throws IOException, InterruptedException {
        return getHttpResponseBody("");
    }

    public static HttpResponse<String> getMarketData(String market) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD");
    }

    public static HttpResponse<String>  getMarketData(String market, String currency) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/" + currency);
    }

    public static HttpResponse<String>  getOrderBook(String market) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/orderbook");
    }

    public static HttpResponse<String>  getOrderBook(String market, int depth) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/orderbook?depth=" + depth);
    }

    public static HttpResponse<String> getTrades(String market) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/trades");
    }

    public static HttpResponse<String>  getTrades(String market, int start, int end) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/trades?=" + start + "&send_time=" + end);
    }

    public static HttpResponse<String>  getHistory(String market) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/candles?resolution=15");
    }

    public static HttpResponse<String>  getHistory(String market, int resolution) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/candles?resolution=" + resolution);
    }

    public static HttpResponse<String>  getHistory(String market, int resolution, int start, int end) throws IOException, InterruptedException {
        return getHttpResponseBody("/" + market + "/USD/candles?resolution=" + resolution + "&start_time=" + start + "&end_time=" + end);
    }
}
