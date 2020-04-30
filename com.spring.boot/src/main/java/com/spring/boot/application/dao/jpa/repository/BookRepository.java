package com.spring.boot.application.dao.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.application.dao.entity.MyBook;



@Repository
public interface BookRepository extends CrudRepository<MyBook, Long> {

	@Query(value = "SELECT b FROM MyBook b" ,nativeQuery = false)
	public List<MyBook> getAllMyBook();
	
}
