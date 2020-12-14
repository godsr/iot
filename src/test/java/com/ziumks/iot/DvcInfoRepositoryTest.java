package com.ziumks.iot;


import com.ziumks.iot.domain.DvcInfo;

import com.ziumks.iot.repository.DvcInfoRepository;

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
public class DvcInfoRepositoryTest {

    @Autowired
    private DvcInfoRepository repository;


    @Test
    public void testFindByDvcId() {

//        repository.saveAndFlush(new Post(7l, "nuga good news", "holy bible", "this line is the only contents."));

        List<DvcInfo> dvcInfos = repository.findByDvcId("SAE359e0ee9-3746-4429-b65e-20bae2f97933");
        assertEquals(1, dvcInfos.size());

        System.out.println(dvcInfos);
        System.out.println(dvcInfos.get(0));
        assertThat(dvcInfos).extracting(DvcInfo::getDvcNm).containsOnly("환경센서4");

    }

}