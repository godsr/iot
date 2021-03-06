package com.ziumks.iot.repository;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	@Query(nativeQuery = true, value = "select * from authors where id < :id")
	List<Author> findByIdRange(Long id);
}
