
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static MarketService.*;


public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv"));

        //System.out.println(getQuoteFor("BTC").get("result").asText());
        //System.out.println(getCandlesFor("BTC").asText());

        JsonNode node = getCandlesFor("BTC");
        ArrayNode arrayNode = (ArrayNode) node;
        for (JsonNode n : arrayNode) {
            writer.write("" + n.get("time").asLong());
            writer.write(",");
            writer.write("" + n.get("open").asDouble());
            writer.write(",");
            writer.write("" + n.get("high").asDouble());
            writer.write(",");
            writer.write("" + n.get("low").asDouble());
            writer.write(",");
            writer.write("" + n.get("close").asDouble());
            writer.write(",");
            writer.write("" + n.get("volume").asDouble());
            writer.newLine();
        }
        writer.close();
    }
}
