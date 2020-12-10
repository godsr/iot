package com.ziumks.iot;


import com.ziumks.iot.domain.DvcInfo;
import com.ziumks.iot.domain.DvcModelInfo;
import com.ziumks.iot.repository.DvcInfoRepository;
import com.ziumks.iot.repository.DvcModelInfoRepository;
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
public class DvcModelInfoRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    private DvcModelInfoRepository repository;




    @Test
    public void testFindByDvcId() {

//        repository.saveAndFlush(new Post(7l, "nuga good news", "holy bible", "this line is the only contents."));

        List<DvcModelInfo> dvcModelInfos = repository.findByDvcModelId("469b0970b0e9455a896524f093924494");
        assertEquals(1, dvcModelInfos.size());

        System.out.println(dvcModelInfos);
        System.out.println(dvcModelInfos.get(0).getPtclType());
        System.out.println(dvcModelInfos.get(0).getPtclTypeNm());
        assertThat(dvcModelInfos).extracting(DvcModelInfo::getModelId).containsOnly("oms3testmodel");

    }

}