package snippets;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("http://api.avatardata.cn/MingRenMingYan/LookUp?key=56ca7b9e4aee431a82bae759161d5905&keyword=%E5%A4%A9%E6%89%8D&page=1&rows=115");
            CloseableHttpResponse response = httpClient.execute(httpGet);

            System.out.println(response.getStatusLine());
            HttpEntity httpEntity = response.getEntity();
            try (InputStream inputStream = response.getEntity().getContent()) {
                StringBuilder stringBuilder = new StringBuilder();
                byte[] bytes = new byte[512];
                int total;
                while ((total = inputStream.read(bytes)) > 0) {
                    stringBuilder.append(new String(bytes, 0, total, StandardCharsets.UTF_8));
                }

                DataModel dataModel = JSON.parseObject(stringBuilder.toString(), DataModel.class);
                for (Result result: dataModel.getResult()) {
                    System.out.println(result.getFamousName() + " - " + result.getFamousSaying());
                }
            }
        } finally {
            httpClient.close();
        }
    }
}
