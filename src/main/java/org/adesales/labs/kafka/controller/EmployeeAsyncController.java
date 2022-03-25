package org.adesales.labs.kafka.controller;

import org.adesales.labs.kafka.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAsyncController {

	@Autowired
	MessageProducerService avroProducer;
	
	@PostMapping("/message/produce/{id}/{firstName}/{lastName}")
	public String produceAvroMsg(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName) {
		avroProducer.sendEmployeeBitacora(id, firstName, lastName);
		
		return "Detalles del empleado enviados al consumidor";
	}
}
