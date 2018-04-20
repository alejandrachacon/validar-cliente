package com.validar.cliente.bs_validar_cliente.config;


import com.validar.cliente.bs_validar_cliente.kafka.ProducerService;
import kafka.Kafka;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.util.Properties;

@Configuration
public class SpringConfig {

    public static final String BOOTSTRAP_SERVERS = "35.171.129.201:9092";
    public static final String SCHEMA_REGISTRY = "http://35.171.129.201:8081";

    @Bean
    public KafkaProducer producer(){
        final Properties producerConfig = new Properties();
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,io.confluent.kafka.serializers.KafkaAvroSerializer.class );
        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        producerConfig.put("acks", "all");
        producerConfig.put("retries", 0);
        producerConfig.put("schema.registry.url", SCHEMA_REGISTRY);

        return new KafkaProducer(producerConfig);
    }

    @Bean
    public ProducerService producerService(final KafkaProducer newProducer){
        return new ProducerService(newProducer);
    }



}
