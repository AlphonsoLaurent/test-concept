package mx.com.ultrasist.proof_of_concept;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import mx.com.ultrasist.proof_of_concept.controller.RestWebController;  


@RunWith(SpringRunner.class)
@WebMvcTest(value = RestWebController.class, secure = false)
 
public class ServiciosRestTest {
	@Autowired
	private MockMvc mockMvc;
	
	MvcResult result;
	
	RequestBuilder requestBuilder;
	 
	@Before
	public void setUp() throws Exception { 
		
		requestBuilder = MockMvcRequestBuilders.get( "/api/customer/all")
						.accept( MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON);
		
	}

	@Test
	public void test() throws Exception { 
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"); 
		MockHttpServletResponse response = result.getResponse(); 
		
		System.out.println("La respuesta:::::::::::::::::::::: "+response.getContentAsString());
		
		assertEquals(200, response.getStatus());
		 
		 
	}
	
	 
}
