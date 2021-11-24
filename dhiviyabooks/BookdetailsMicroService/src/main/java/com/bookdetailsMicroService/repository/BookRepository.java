package com.bookdetailsMicroService.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bookdetailsMicroService.model.Books;


@Repository
public interface BookRepository extends JpaRepository<Books,Integer> 
{
	
}