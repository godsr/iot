package com.ziumks.iot;



import com.ziumks.iot.domain.StreamInfo;

import com.ziumks.iot.repository.StreamInfoRepository;
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
public class StreamInfoRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    private StreamInfoRepository repository;




    @Test
    public void testFindByDvcId() {

//        repository.saveAndFlush(new Post(7l, "nuga good news", "holy bible", "this line is the only contents."));

        List<StreamInfo> streamInfos = repository.findByStreamPkId("76186c12afed479f9082f9d515342b18");
        assertEquals(1, streamInfos.size());

        System.out.println(streamInfos);
        System.out.println(streamInfos.get(0));
        assertThat(streamInfos).extracting(StreamInfo::getStreamNm).containsOnly("lmx");

    }

}