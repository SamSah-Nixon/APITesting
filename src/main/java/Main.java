import java.io.IOException;
import java.net.URISyntaxException;
import com.fasterxml.jackson.databind.JsonNode;
public class Main {
  public static void main(String[] args) throws URISyntaxException, IOException {
    String apiKey = "82a3de04-11d3-40b1-96f4-b1e58b8c33c0";
    String uuid = "6038fb8c2bef4d7eb040668560be5b69";
    EditableURI uri = new EditableURI("https://api.hypixel.net/guild?");
    uri.addParameter("key=", "apiKey",apiKey);
    uri.addParameter("&player=", "uuid",uuid);
    System.out.println("!"+uri);
    Endpoint guild = new Endpoint(uri);
    JsonNode node = guild.fetch();
    System.out.println(node.toString());
  }
}
