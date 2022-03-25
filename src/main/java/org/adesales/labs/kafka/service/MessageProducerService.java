package org.adesales.labs.kafka.service;

import org.adesales.labs.kafka.schema.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

	@Autowired
	private Processor processor;
	
	public void sendEmployeeBitacora(int empId, String firstName, String lastName) {
		Employee empleado = Employee.newBuilder()
				.setId(empId)
				.setFirstName(firstName)
				.setLastName(lastName)
				.build();
		Message<Employee> mensaje = MessageBuilder
									.withPayload(empleado)
									.build();
		
		processor
			.output()
			.send(mensaje);
	}
}
