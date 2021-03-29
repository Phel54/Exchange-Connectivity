package com.kepf.Exchangeconnectivity.queues;

import com.kepf.Exchangeconnectivity.modules.MarketData;
import com.kepf.Exchangeconnectivity.modules.PendingOrders;
import com.kepf.Exchangeconnectivity.utility_and_connection.RedisConnection;
import com.kepf.Exchangeconnectivity.utility_and_connection.Utility;
import org.springframework.web.reactive.function.client.WebClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class GetMarketData implements Runnable{
    private static final String API_KEY = "5d08f9f0-c5b2-497c-a3f1-9bac8fe16741";

    @Override
    public void run() {

        while (true) {
            Jedis jedis = null;
            try {
                jedis = (new RedisConnection()).createConnection();
            } catch (JedisDataException e) {
                e.printStackTrace();
            }

            MarketData[] response = null;
            response = WebClient.builder()
                    .baseUrl("https://exchange.matraining.com")
                    .build()
                    .get()
                    .uri("/md"+"/")
                    .retrieve()
                    .bodyToMono(MarketData[].class)
                    .block();


            System.out.println(response.toString());
           String result = Utility.convertToString(response);
            System.out.println(result);

          jedis.lpush("marketdata",result);

        }

    }
}
