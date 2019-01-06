package com.example.kafkaDemo;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

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

    public void SendRecordAsync(){
        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);
        try {
            for (int i = 0; i < 10000; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("test", "Precision Products", i + "__France_" + new Date());
                producer.send(record, new ProductCallback());
            }
            System.out.println("OK");

        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    public void SendRecordRealtime(){
        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);
        try {
            for (int i = 0; i < 10000; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>("test", "Precision Products", i + "__France_" + new Date());
                producer.send(record).get();
            }
            System.out.println("OK");

        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    public void SendRecordFlush() {
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

class ProductCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if(exception != null){
            exception.printStackTrace();
        }
    }
}
