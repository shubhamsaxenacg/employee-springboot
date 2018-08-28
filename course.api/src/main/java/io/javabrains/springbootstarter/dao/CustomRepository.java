package io.javabrains.springbootstarter.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.springbootstarter.pojo.Topics;

@Repository
public interface CustomRepository extends JpaRepository<Topics, Integer>  {

	//void addTopic(Topics topics);
	

	
}
