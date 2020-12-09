package com.ziumks.iot.repository;

import com.ziumks.iot.domain.Account;
import com.ziumks.iot.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long>{

	Post findByTitle(String title);
}
