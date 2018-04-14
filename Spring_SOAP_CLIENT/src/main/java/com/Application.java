package com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.generated.AddIntegersResponse;
import com.generated.GetCountryResponse;
import com.generated.GetfactorialResponse;
import com.spring.service.soap.client.CountryClient;
import com.spring.service.soap.client.MathOperationClient;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("************ Main *************");
		SpringApplication.run(Application.class);
		System.out.println("************ Exiting Main *************");
	}

	@Bean
	CommandLineRunner lookupCountry(CountryClient client) {
		System.out.println(Thread.currentThread().getName()
				+ " lookupCountry.....");
		return args -> {
			String countryName = "Spain";

			if (args.length > 0) {
				countryName = args[0];
			}
			GetCountryResponse response = client.getCountryDetails(countryName);
			System.out.println("lookupCountry....." + response.getCountry());
			ObjectMapper mapper = new ObjectMapper();
			try {
				String jsonInString = mapper.writeValueAsString(response);
				System.out.println("jsonInString : " + jsonInString);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}

	@Bean
	CommandLineRunner lookupFactorial(MathOperationClient client) {
		System.out.println(Thread.currentThread().getName()
				+ " lookupFactorial.....");
		return args -> {
			int input = 3;

			if (args.length > 0) {
				input = Integer.parseInt(args[0]);
			}
			GetfactorialResponse response = client.factorial(input);
			System.out.println("lookupFactorial....." + response.getNumber());
			ObjectMapper mapper = new ObjectMapper();
			try {
				String jsonInString = mapper.writeValueAsString(response);
				System.out.println("jsonInString : " + jsonInString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		};
	}

	@Bean
	CommandLineRunner lookupAddition(MathOperationClient client) {
		System.out.println(Thread.currentThread().getName()
				+ " lookupAddition.....");
		return args -> {
			int input1 = 3;
			int input2 = 200;
			if (args.length > 1) {
				input1 = Integer.parseInt(args[0]);
				input2 = Integer.parseInt(args[1]);
			}
			AddIntegersResponse response = client.addInteger(input1, input2);
			System.out.println("lookupAddition....." + response.getSum());
			ObjectMapper mapper = new ObjectMapper();
			try {
				String jsonInString = mapper.writeValueAsString(response);
				System.out.println("jsonInString : " + jsonInString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		};
	}
}
