package snippets;

import org.springframework.web.client.RestTemplate;

public class Client {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        ModelData modelData = restTemplate.getForObject("http://api.avatardata.cn/MingRenMingYan/LookUp?key=56ca7b9e4aee431a82bae759161d5905&keyword=天才&page=1&rows=15", ModelData.class);

        for (Result result : modelData.getResult())
            System.out.println(result.getFamousSaying());
    }
}
