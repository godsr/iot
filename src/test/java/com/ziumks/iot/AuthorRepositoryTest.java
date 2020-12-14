package com.ziumks.iot;


import com.ziumks.iot.domain.Author;
import com.ziumks.iot.repository.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    private AuthorRepository repository;




    @Test
    @Transactional
    public void testFindByLastName() {

//        repository.saveAndFlush(new Author("Paul", "Sadam", "niku@stsall.com"));
//
//        List<Author> authors = repository.findByLastName("Sadam");
//        assertEquals(1, authors.size());
//
//        assertThat(authors).extracting(Author::getLastName).containsOnly("Sadam");

    }

}