public class Progress {
    public static void main(String[] args){
        System.out.println("Hello world");

        TestKafkaProducer testKafkaProducer  = new TestKafkaProducer();
        testKafkaProducer.SendRecord();
    }
}
