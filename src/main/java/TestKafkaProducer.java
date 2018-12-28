import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

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

        ProducerRecord<String, String> record = new ProducerRecord<>("test", "Precision Products", "France");

        try {
            producer.send(record);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
