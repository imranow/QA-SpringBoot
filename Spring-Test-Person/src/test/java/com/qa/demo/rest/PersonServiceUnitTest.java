package com.qa.demo.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.demo.persistence.domain.Person;
import com.qa.demo.persistence.repo.PersonRepo;
import com.qa.demo.service.PersonService;

@SpringBootTest
public class PersonServiceUnitTest {

    @Autowired
    private PersonService service;

    @MockBean
    private PersonRepo repo;

    @Test
    void testCreate() {
    	 // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
        final Person TEST_PERSON = new Person(null, 26, "JH");
        final Person TEST_SAVED_PERSON = new Person(1L, 26, "JH");

        // WHEN
        Mockito.when(this.repo.save(TEST_PERSON)).thenReturn(TEST_SAVED_PERSON);

        // THEN
        Assertions.assertThat(this.service.create(TEST_PERSON)).isEqualTo(TEST_SAVED_PERSON);

        // verify that our repo was accessed exactly once
        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_PERSON);
    }

}
