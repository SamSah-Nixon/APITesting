
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.net.URISyntaxException;
public class Endpoint {

    EditableURI uri;

    public Endpoint(EditableURI uri) {
        this.uri = uri;
    }


    public JsonNode fetch()
            throws URISyntaxException, IOException {
        String response_content = "";

        URIBuilder query = new URIBuilder(uri.toString());

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());

        //request.setHeader(HttpHeaders.ACCEPT, "application/json");
        //request.addHeader("X-CMC_PRO_API_KEY", api_key);

        CloseableHttpResponse response = client.execute(request);

        try {
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            response.close();
        }

        return Json.parse(response_content);
    }

    public String fetch(String... index){
        try {
            JsonNode node = fetch();
            for (String i : index) {
               node = node.get(i);
            }
            return node.asText();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getURI(){
        return uri.toString();
    }
}
