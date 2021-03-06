package com.ziumks.iot.repository;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.domain.Post;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByTitle(String title);

}
