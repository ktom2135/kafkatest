package com.example.kafkaDemo;

public class KafkaDemoApplication {

    public static void main(String[] args) {
        System.out.println("Hello world");

        TestKafkaProducer testKafkaProducer = new TestKafkaProducer();
        //testKafkaProducer.SendRecordFlush();
        //testKafkaProducer.SendRecordRealtime();
        testKafkaProducer.SendRecordAsync();

        TestKafkaComsumer testKafkaComsumer = new TestKafkaComsumer();
        testKafkaComsumer.PullMessage();
    }

}

