package org.adesales.labs.kafka.service;

import org.adesales.labs.kafka.schema.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("deprecation")
public class MessageConsumerService {

	public static final Logger log = LoggerFactory.getLogger(MessageConsumerService.class);
	
	@StreamListener(Processor.INPUT)
	public void consumeEmployeeBitacora(Employee employee) {
		log.info("Vamos a procesar los detalles del empleado: {}", employee);
	}
}
