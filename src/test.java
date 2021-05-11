import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        String json = "{\"objects\" : [\"One\", \"Two\", \"Three\"],\"test\" :\"test\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        JsonNode arrNode = jsonNode.get("objects");
        System.out.println(jsonNode.get("test").getNodeType());
        if (arrNode.isArray()){
            for (JsonNode node : arrNode) {
                System.out.println(node);
            }
        }
        System.out.println(Integer.MIN_VALUE);



    }
}
