package com.ziumks.iot;


import com.ziumks.iot.domain.Author;
import com.ziumks.iot.domain.Post;
import com.ziumks.iot.repository.AuthorRepository;
import com.ziumks.iot.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    private PostRepository repository;




    @Test
    public void testFindByLastName() {

        repository.saveAndFlush(new Post(7l, "nuga good news", "holy bible", "this line is the only contents."));

        List<Post> posts = repository.findByTitle("nuga good news");
        assertEquals(1, posts.size());

        assertThat(posts).extracting(Post::getTitle).containsOnly("nuga good news");

    }

}