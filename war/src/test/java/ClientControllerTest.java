import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientControllerTest {
        @Test
        public void returnByIdTest() throws IOException {
            restTest("http://localhost:8080/war/client/1", "client/1.json");
        }
        @Test
        public void returnAllTest() throws IOException {
            restTest("http://localhost:8080/war/client", "client/all.json");
        }

        private void restTest(String aRestUrl, String aPreparedFilePath) throws IOException {
            HttpGet getRequest = new HttpGet(aRestUrl);
            JsonParser parser = new JsonParser();
            FileReader preparedFile = new FileReader(
                    getClass().getClassLoader().getResource(aPreparedFilePath).getFile());
            JsonElement expected = parser.parse(preparedFile);
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute(getRequest);
            String content = EntityUtils.toString(httpResponse.getEntity());
            assertEquals(200, httpResponse.getStatusLine().getStatusCode());
            JsonElement result = parser.parse(content);
            assertEquals(expected, result);
        }
    }
