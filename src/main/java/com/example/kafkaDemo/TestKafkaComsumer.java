package com.example.kafkaDemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class TestKafkaComsumer {
    Properties props = new Properties();

    public TestKafkaComsumer() {
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "*");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    }

    public void PullMessage() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("test"));
        try {
            while (true) {
                Duration duration = Duration.ofMillis(100);
                ConsumerRecords<String, String> records = consumer.poll(duration);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic() + ", " +
                            "partition = " + record.partition() + ", " +
                            "offset = " + record.offset() + ", " +
                            "customer = " + record.key() + ", " +
                            "country = " + record.value());
                }
            }
        } finally {
            consumer.close();
        }
    }
}
