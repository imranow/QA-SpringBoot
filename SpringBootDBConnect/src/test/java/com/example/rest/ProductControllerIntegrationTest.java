package com.example.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:person-schema.sql",
		"classpath:person-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ProductControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	private final Product TEST_PRODUCT = new Product(101, "Iphone", "Apple");

	private final Product TEST_SAVED_PRODUCT = new Product(101, "Iphone", "Apple");

	@Test
	public void testCreate() throws JsonProcessingException, Exception {
		String resultString = this.mockMVC
				.perform(post("/product/create").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(TEST_PRODUCT)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		Product result = this.mapper.readValue(resultString, Product.class);
		assertThat(result).isEqualTo(TEST_PRODUCT);
	}

	@Test
	public void testReadOne() throws Exception {
		this.mockMVC.perform(get("/product/read/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_PRODUCT)));

	}

	@Test
	public void testZZZ() throws Exception {
		final List<Product> PEOPLE = new ArrayList<>();
		PEOPLE.add(TEST_SAVED_PRODUCT);

		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/product/readAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<Product> results = Arrays.asList(mapper.readValue(resultString, Product[].class));
		assertThat(results).contains(this.TEST_PRODUCT).hasSize(3);
	}

	@Test
	public void testUpdate() throws Exception {
		final Product newPerson = new Product(101, "Apple watch", "Apple");
		String resultString = this.mockMVC
				.perform(put("/product/update/3").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newPerson)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		Product result = this.mapper.readValue(resultString, Product.class);
		assertThat(result).isEqualTo(newPerson);
	}

	@Test
	public void testDelete() throws Exception {
		this.mockMVC.perform(delete("/person/delete/2")).andExpect(status().isNoContent());
	}
}


