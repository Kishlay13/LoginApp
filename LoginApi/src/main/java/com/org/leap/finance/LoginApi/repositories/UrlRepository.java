package com.org.leap.finance.LoginApi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.leap.finance.LoginApi.model.Content;

public interface UrlRepository extends JpaRepository<Content, Long> {

	//@Query(value="SELECT * FROM Content WHERE user_id ":user_id")
	List<Content> findAllByUserId(long user_id);

}
