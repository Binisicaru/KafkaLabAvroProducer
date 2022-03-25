package org.adesales.labs.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableBinding(Processor.class)
@EnableSchemaRegistryClient
public class KafkaLabAvroProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaLabAvroProducerApplication.class, args);
	}
	
	@Value("${spring.cloud.stream.kafka.binder.producer-properties.schema.registry.url}")
	private String endpoint;
	
	@Bean
	public SchemaRegistryClient schemaRegistryClient() {
		ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
		client.setEndpoint(endpoint);
		return client;
	}

}
