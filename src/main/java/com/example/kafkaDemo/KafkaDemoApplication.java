package com.example.kafkaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello world");

		TestKafkaProducer testKafkaProducer  = new TestKafkaProducer();
		testKafkaProducer.SendRecord();
	}

}

