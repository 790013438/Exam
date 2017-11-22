package snippets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App {

    public static void main(String[] args) throws Exception {
        //Apache - HttpClient
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.avatardata.cn/MingRenMingYan/LookUp?key=56ca7b9e4aee431a82bae759161d5905&keyword=%E5%A4%A9%E6%89%8D&page=1&rows=115");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String jsonStr = EntityUtils.toString(httpResponse.getEntity(), "utf-8");

        //使用Jackson提供的工具将字符串解析成对象
        ObjectMapper objectMapper = new ObjectMapper();
        DataModel dataModel = objectMapper.readValue(jsonStr, DataModel.class);

        for (Result model : dataModel.getResult()) {
            System.out.println(model.getFamousName());
            System.out.println(model.getFamousSaying());
        }
    }
}
