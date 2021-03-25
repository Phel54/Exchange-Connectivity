package com.kepf.Exchangeconnectivity;

import com.kepf.Exchangeconnectivity.queues.MakeOrder;
import com.kepf.Exchangeconnectivity.queues.PlaceOrders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
//@RestController

public class ExchangeConnectivityApplication {


	private static final String API_KEY = "5d08f9f0-c5b2-497c-a3f1-9bac8fe16741";
	private static final String EXCHANGE_1 = "https://exchange.matraining.com";

	public static void main(String[] args) {
		SpringApplication.run(ExchangeConnectivityApplication.class, args);

//		Thread makeOrderToExchange1 = new Thread(new MakeOrder("exchange1OrderRequest"));
//		makeOrderToExchange1.start();

		Thread placeOrderToExchangeOne = new Thread(new PlaceOrders());
		placeOrderToExchangeOne.start();

	}

	@RequestMapping(method = {RequestMethod.GET},path = "api/v1")
	public String getApi(){
		return "This is the Exchange-Connectivity Api v1";
	}









}
