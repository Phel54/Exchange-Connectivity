package com.kepf.Exchangeconnectivity.utility_and_connection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;



public class RedisConnection {

    private static final int PORT = 14149;


    public Jedis createConnection() throws JedisDataException {
       Jedis jedis = new Jedis("redis-14149.c258.us-east-1-4.ec2.cloud.redislabs.com", PORT);
        jedis.auth("Phelim@54");

        return (jedis);
    }
}




