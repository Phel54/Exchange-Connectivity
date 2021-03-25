package com.kepf.Exchangeconnectivity.utility_and_connection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.net.URI;
import java.net.URISyntaxException;



public class RedisConnection {

    private static final int PORT = 11243;

//    public static void main(String[] args) {
//        //Connecting to Redis server on localhost
//        Jedis jedis = new Jedis("redis-11243.c74.us-east-1-4.ec2.cloud.redislabs.com",11243);
//        jedis.auth("lzlPsMRIJL1oopPjHIGmORyVBhhOLZYR");
//        System.out.println("Connection to server sucessfully");
//        //check whether server is running or not
//        System.out.println("Server is running: "+jedis.ping());
//
//
//        //store data in redis list
//        jedis.lpush("tutorial-list", "Redis");
//        jedis.lpush("tutorial-list", "Mongodb");
//        jedis.lpush("tutorial-list", "Mysql");
//        // Get the stored data and print it
//        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
//
//        for(int i = 0; i<list.size(); i++) {
//            System.out.println("Stored string in redis:: "+list.get(i));
//        }
//    }

    public Jedis createConnection() throws JedisDataException {
       Jedis jedis = new Jedis("redis-14149.c258.us-east-1-4.ec2.cloud.redislabs.com",14149);
        jedis.auth("Phelim@54");
        return (jedis);
    }
}




