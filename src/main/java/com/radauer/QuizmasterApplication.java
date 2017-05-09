package com.radauer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class QuizmasterApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(QuizmasterApplication.class, args);
    }

   /* @Bean
    public RestTemplate imageCheckerRestTemplate()
    {

        CloseableHttpClient client = HttpClientBuilder.create()
            // Important! honors http.proxyHost and https.proxyHost
            .setRoutePlanner(new SystemDefaultRoutePlanner(ProxySelector.getDefault()))
            .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(client);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }*/

    @Bean
    public RestTemplate restTemplate()
    {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

        return new RestTemplate(requestFactory);
    }
}
