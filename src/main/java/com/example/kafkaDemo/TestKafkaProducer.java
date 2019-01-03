package com.example.kafkaDemo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.DateTimeException;
import java.util.Date;
import java.util.Properties;

public class TestKafkaProducer {
    private Properties kafkaProps = new Properties();

    public TestKafkaProducer() {
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    }

    public void SendRecord() {
        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);


        try {
            for (int i = 0; i < 10000; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("test", "Precision Products", i + "__France_" + new Date());
                producer.send(record);
            }

            producer.flush();
            System.out.println("OK");

        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}
