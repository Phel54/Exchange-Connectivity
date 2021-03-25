package com.kepf.Exchangeconnectivity.queues;

import com.kepf.Exchangeconnectivity.modules.Orders;
import com.kepf.Exchangeconnectivity.utility_and_connection.RedisConnection;
import com.kepf.Exchangeconnectivity.utility_and_connection.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.net.URISyntaxException;

public class PlaceOrders implements Runnable {
    private static final String API_KEY = "5d08f9f0-c5b2-497c-a3f1-9bac8fe16741";
    private static final String EXCHANGE_1 = "https://exchange.matraining.com";

    //Connecting to Redis server on localhost




    @Override
    public void run() {
        while (true) {
            Jedis jedis = null;
            try {
                jedis = (new RedisConnection()).createConnection();
            } catch (JedisDataException e) {
                e.printStackTrace();
            }


//            if (data == null) {
//                System.out.println("THere is no more data in the queue");
//                continue;
//            }
            if(jedis.lindex("makeOrderExchange1",0) !=null) {
                String data = jedis.rpop("makeOrderExchange1");

                System.out.println("exchange1");
                String order2 = Utility.convertToString(data);
                System.out.println(order2);

                Orders order = Utility.convertToObject(data, Orders.class);


                WebClient webClient = WebClient.create(EXCHANGE_1);
                String orderId = webClient.post().uri("/" + API_KEY + "/order")
                        .body(Mono.just(order), Orders.class)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

                System.out.println("Order placed successfully, orderId: " + orderId);
            }

        }
    }
}
