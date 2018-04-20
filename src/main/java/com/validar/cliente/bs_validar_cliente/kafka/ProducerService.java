package com.validar.cliente.bs_validar_cliente.kafka;


import com.validar.cliente.bs_validar_cliente.model.Cliente;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;



import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;


public class ProducerService {

    private static Schema CLIENTE_SCHEMA;
    final KafkaProducer<String, GenericRecord> producer;
    private static final String TOPIC = "gestionClientes";


    static{
        InputStream clienteSchema = ProducerService.class.getClassLoader().getResourceAsStream("cliente.json");
        try {
            CLIENTE_SCHEMA = new Schema.Parser().setValidate(true).parse(clienteSchema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ProducerService(final KafkaProducer newProducer) {
        this.producer = newProducer;
    }


    @SuppressWarnings("unchecked")
    public void sendToKafka(String key, GenericRecord recordCliente){
         this.producer.send(producerRecordFrom.apply(key,recordCliente));
    }


    public final BiFunction<String, GenericRecord, ProducerRecord> producerRecordFrom = (key, value) ->
            new ProducerRecord<>(TOPIC, key, value);


    public Schema getClientSchema() {
        return CLIENTE_SCHEMA;
    }
}
