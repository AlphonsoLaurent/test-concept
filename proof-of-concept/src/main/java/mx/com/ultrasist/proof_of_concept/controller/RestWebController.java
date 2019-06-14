package mx.com.ultrasist.proof_of_concept.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ultrasist.proof_of_concept.message.Response;
import mx.com.ultrasist.proof_of_concept.model.Customer;
import mx.com.ultrasist.proof_of_concept.model.ResponseDTO;

@RestController
@RequestMapping("/proof-of-concept/api/customer")
public class RestWebController {
	static Logger log = LoggerFactory.getLogger(RestWebController.class);

	static List<Customer> cust = null; 
	
	@GetMapping(value = "/all")
	@ResponseBody
	public ResponseEntity<ResponseDTO> getResource() throws UnknownHostException {
		cust = new ArrayList<>();
		final String serverAddress = InetAddress.getLocalHost().getHostAddress();
		Customer custom = null;
		Random random = new Random();
		int randomInt = random.nextInt(70);
		for(int x = 0; x<=randomInt; x++) {
			custom = new Customer();
			custom.setFirstname("Pedro "+x);
			custom.setLastname("Picapiedra "+x);
			cust.add(custom);
		}
		
		
		if(true) {
			for (int i = 0; i < 10; i++) {
				System.out.println("hola "+i);
			}
		}
		ResponseDTO response = getResponse(true, "::::::Peticion realizada en la IP: "+serverAddress, cust);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK); //list
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Customer customer) {
		log.info("::::::::::::::::::::::postCustomer::::::::::::::::::::::");
		cust.add(customer); 
		/* Create Response Object
		Response response = new Response("Done", customer);*/
		return new Response("Done", customer);
	}
	
	
	public ResponseDTO getResponse(boolean isSuccessful, String msgFinal, Object ...objects) {
		ResponseDTO response = new ResponseDTO(false);
		List<Object> lstResponse = null;
		if(objects != null && objects.length>0) {
			lstResponse = new ArrayList<Object>();
			for (Object object : objects) {
				lstResponse.add(object);
			}
		}
		response.setSuccessful(isSuccessful);
		response.setMsgSuccess(msgFinal);
		response.setLstResponse(lstResponse);
		return response;
	}
}