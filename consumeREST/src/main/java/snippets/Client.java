package snippets;

import org.springframework.web.client.RestTemplate;

public class Client {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        ModelData modelData = restTemplate.getForObject("http://api.avatardata.cn/MingRenMingYan/LookUp?key=56ca7b9e4aee431a82bae759161d5905&keyword=%E5%A4%A9%E6%89%8D&page=1&rows=15", ModelData.class);
        System.out.println(modelData.getResult());
    }
}
