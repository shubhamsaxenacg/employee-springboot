package io.javabrains.springbootstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.dao.CustomRepository;

import io.javabrains.springbootstarter.pojo.Topics;

@Service
public class TopicService {
	@Autowired
	private CustomRepository dao;

	public List<Topics> viewAll() {
		return dao.findAll();
	}

	public Topics viewById(int id) {

		return  dao.findById(id).get();
		 
	}

	public void addTopic(Topics topic) {
		dao.save(topic);
	
	}

	public void updateTopic(int id, Topics topic) {
	
		dao.save(topic);

	}

	public void delete(int id) {
		
		dao.deleteById(id);
		
	
	}
	
}
