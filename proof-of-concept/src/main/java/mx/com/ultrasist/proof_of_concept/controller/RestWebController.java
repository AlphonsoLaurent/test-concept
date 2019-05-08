package mx.com.ultrasist.proof_of_concept.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ultrasist.proof_of_concept.message.Response;
import mx.com.ultrasist.proof_of_concept.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {
	static Logger log = LoggerFactory.getLogger(RestWebController.class);

	static List<Customer> cust = new ArrayList<Customer>();

	static {
		Customer custom = null;
		for(int x = 0; x<=10; x++) {
			custom = new Customer();
			custom.setFirstname("Alfonso "+x);
			custom.setLastname("Laureano "+x);
			cust.add(custom);
		}
	} 
	
	
	@GetMapping(value = "/all")
	@ResponseBody
	public Response getResource() {
		log.info("::::::::::::::::::::::HOLA ESTA ES UNA PRUEBA DEL LOG4J::::::::::::::::::::::");
		Response response = new Response("Done", cust); 
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Customer customer) {
		log.info("::::::::::::::::::::::postCustomer::::::::::::::::::::::");
		cust.add(customer);
		
		// Create Response Object
		Response response = new Response("Done", customer);
		return response;
	}
}