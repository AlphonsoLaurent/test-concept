package mx.com.ultrasist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ultrasist.message.Response;
import mx.com.ultrasist.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

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
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Customer customer) {
		cust.add(customer);
		
		// Create Response Object
		Response response = new Response("Done", customer);
		return response;
	}
}