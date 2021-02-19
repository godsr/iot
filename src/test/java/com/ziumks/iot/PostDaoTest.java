package com.ziumks.iot;


import com.ziumks.iot.dao.PostDao;

import com.ziumks.iot.domain.Author;
import com.ziumks.iot.domain.Post;
import com.ziumks.iot.repository.AuthorRepository;
import com.ziumks.iot.repository.PostRepository;

import org.hibernate.Session;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDaoTest {


    @Autowired
    private PostDao postDao;

	@Autowired
	EntityManager em;


//    @Test
//    public void testGetAll() {
//
//    	Map<String, Object> paramMap = new HashMap<String, Object>();
//    	
//    	//List<Post> lists = postDao.getListAll(paramMap);
//
//
////        assertEquals(1004, lists.size());
//        
//        postDao.test();
//
//        
//
//    }
    
    @Test
    public void test_sql_hibernate_dto_query_example() {
//    	Query query = em.createNativeQuery("SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info");
//    	query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    	
//    	Session session = em.unwrap(Session.class);
//    	List<Map<String, Object>> mapList = session.createNativeQuery("SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info")
//    			.setResultTransformer( Transformers.ALIAS_TO_ENTITY_MAP );
//    	        .list();
    	        
//    	System.out.println(mapList);        
    	//query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    	
    	
//    	List<PersonSummaryDTO> dtos = session.createNativeQuery(
//    	          "SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info")
//    	        .setResultTransformer( Transformers.ALIAS_TO_ENTITY_MAP )
//    	        .list();
    	
    	
    	
//      doInJPA( this::entityManagerFactory, entityManager -> {
//        Session session = entityManager.unwrap( Session.class );
//        //tag::sql-hibernate-dto-query-example[]
//        List<PersonSummaryDTO> dtos = session.createNativeQuery(
//          "SELECT p.id as \"id\", p.name as \"name\" " +
//          "FROM Person p")
//        .setResultTransformer( Transformers.aliasToBean( PersonSummaryDTO.class ) )
//        .list();
//        //end::sql-hibernate-dto-query-example[]
//        assertEquals(3, dtos.size());
//      });
    }

}