package com.qa.demo.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.persistence.domain.Person;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:person-schema.sql",
		"classpath:person-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PersonControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	private final Person TEST_SAVED_PERSON = new Person(1L, 26, "Jordan Harrison");

	@Test
	public void testCreate() throws Exception {
		final Person newPerson = new Person(null, 26, "Chris Perrins");
		final Person savedPerson = new Person(4L, newPerson.getAge(), newPerson.getName());

		this.mockMVC
				.perform(post("/person/create").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newPerson)))
				.andExpect(status().isCreated()).andExpect(content().json(this.mapper.writeValueAsString(savedPerson)));
	}

	@Test
	public void testReadOne() throws Exception {
		this.mockMVC.perform(get("/person/read/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_PERSON)));

	}

	@Test
	public void testReadAll() throws Exception {
		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/person/readAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<Person> results = Arrays.asList(mapper.readValue(resultString, Person[].class));
		assertThat(results).contains(this.TEST_SAVED_PERSON).hasSize(3);
	}

	@Test
	public void testUpdate() throws Exception {
		final Person newPerson = new Person(null, 26, "Chris Perrins");
		String resultString = this.mockMVC
				.perform(put("/person/update/3").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newPerson)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		Person result = this.mapper.readValue(resultString, Person.class);
		assertThat(result).isEqualTo(newPerson);
	}

	@Test
	public void testDelete() throws Exception {
		this.mockMVC.perform(delete("/person/delete/2")).andExpect(status().isNoContent());
	}
}
