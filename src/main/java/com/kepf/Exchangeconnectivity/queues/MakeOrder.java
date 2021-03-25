package com.kepf.Exchangeconnectivity.queues;

import com.kepf.Exchangeconnectivity.modules.OrderBookRequest;
import com.kepf.Exchangeconnectivity.modules.PendingOrders;
import com.kepf.Exchangeconnectivity.utility_and_connection.RedisConnection;
import com.kepf.Exchangeconnectivity.utility_and_connection.Utility;
import org.springframework.web.reactive.function.client.WebClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.net.URISyntaxException;
import java.util.Arrays;

public class MakeOrder implements Runnable{
    private final String CHANNEL_NAME;

    public MakeOrder(String name) {
        this.CHANNEL_NAME = name;
    }



    @Override
    public void run() {
        while (true) {

            Jedis jedis = null;
            try {
                jedis = (new RedisConnection()).createConnection();
            } catch (JedisDataException e) {
                e.printStackTrace();
            }

            String data = jedis.rpop(this.CHANNEL_NAME);
            if (data == null) continue;
            System.out.println(data);
            OrderBookRequest orderBookRequest = Utility.convertToObject(data, OrderBookRequest.class);

            PendingOrders[] response = null;
            String product = orderBookRequest.product;

            String side = orderBookRequest.side.toLowerCase();

            if (side.equals("sell")){
                response = WebClient.builder()
                        .baseUrl("https://exchange.matraining.com")
                        .build()
                        .get()
                        .uri("/orderbook"+"/"+product+"/"+"buy")
                        .retrieve()
                        .bodyToMono(PendingOrders[].class)
                        .block();



            }else {
                response = WebClient.builder()
                        .baseUrl("https://exchange.matraining.com")
                        .build()
                        .get()
                        .uri("/orderbook"+"/"+product+"/"+"sell")
                        .retrieve()
                        .bodyToMono(PendingOrders[].class)
                        .block();


            }

            String result = Utility.convertToString(response);

            PendingOrders[] pendingOrders = Utility.convertToObject(result,PendingOrders[].class);
            if (pendingOrders == null) {
                System.out.println("Pending orders null");
            }
            for (PendingOrders pendingOrder : pendingOrders) {
                pendingOrder.setExchange("exchange1");
            }
            jedis.lpush(orderBookRequest.getId() + "orderbook",Utility.convertToString(pendingOrders));
        }
    }
}
