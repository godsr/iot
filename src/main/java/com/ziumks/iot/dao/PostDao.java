package com.ziumks.iot.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ziumks.iot.domain.Post;


@Repository(value = "PostDao")
public class PostDao {
	private static final Logger logger = LogManager.getLogger(PostDao.class);

	@Autowired
	EntityManager em;

//	public List<Post> getListAll(Map<String, Object> paramMap) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(" SELECT post FROM Post as post   ");
//		logger.info("sql : ", sb.toString());
//		TypedQuery<Post> query = em.createQuery(sb.toString(), Post.class);
//
//		List<Post> resultList = query.getResultList();
//
//		return resultList;
//	}
	
	
	public void test() {
		Query query = em.createNativeQuery("SELECT cd_nm, cd, cd_desc FROM iot_web.comm_cd_info");
		query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List r = query.getResultList();
	
		for(Object obj : r) {
		      Map row = (Map) obj;
		              
		      System.out.println("key : " + row.get("cd") + "\t\t\t\tvalue : " + row.get("cd_nm")+ "\t\t\t\tvalue : " + row.get("cd_desc"));
		         
		}
	}
}
