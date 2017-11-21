package snippets;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://api.tianapi.com/txapi/dictum/?key=67c176c58cb185f76518c6b5871f6e1a");

        HttpURLConection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("post");
        connection.addRequestProperty("apikey", "67c176c58cb185f76518c6b5871f6e1a"");

        try (InputStream input = url.openStream()){
            StringBuilder jsonStr = new StringBuilder();
            byte[] buffer = new byte[512];
            int totalBytes;
            while ((totalBytes = input.read(buffer)) != -1) {
                jsonStr.append(new String(buffer, 0, totalBytes, "utf-8"));
            }

            DataModel dataModel = JSON.parseObject(jsonStr.toString(), DataModel.class);
            for (News news : dataModel.getNewsList()) {
                System.out.println(news.getContent());
            }
        } catch (Exception e) {
        }
    }
}
