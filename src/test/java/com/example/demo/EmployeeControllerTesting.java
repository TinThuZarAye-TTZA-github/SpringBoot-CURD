package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTesting {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAllEmployee() throws Exception {
		this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void addEmployee() throws Exception {
		Employee newEmp = new Employee(5, "Mary", "123 Street", "CA");
		this.mockMvc.perform(post("/employee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newEmp)))
				.andDo(print())
				.andExpect(status().isCreated());
		
		
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
