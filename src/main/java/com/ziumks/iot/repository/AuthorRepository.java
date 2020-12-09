package com.ziumks.iot.repository;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	Author findByLastName(String name);
}
