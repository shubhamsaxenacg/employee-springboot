package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static  org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import io.javabrains.springbootstarter.pojo.Topics;
import io.javabrains.springbootstarter.service.TopicService;

@RestController
public class TopicController {
	@Autowired
	private TopicService service;

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{start}/{count}"  /*,produces=MediaType.APPLICATION_XML_VALUE*/)
	public Resources topicsByPage(@PathVariable int start,@PathVariable int count) {
		List<Topics> tempTopics=service.viewAll();
		List<Topics> topics=new ArrayList<>();
		
		for(int i=start;i<start+count;i++) {
			topics.add(tempTopics.get(i-1));
		}
		
		Link nextLink= linkTo(methodOn(this.getClass()).topicsByPage(start+count, count)).withRel("next");
		Link previousLink= linkTo(methodOn(this.getClass()).topicsByPage(start-count>=0?start-count:1, count)).withRel("previous");
		//@SuppressWarnings({"rawtypes","unchecked"})
		Resources resources = new Resources<>(topics,nextLink,previousLink);
		return resources;
	}
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics() {
		
		return service.viewAll();
	}

	@RequestMapping("/topics/{id}")
	public ResponseEntity<Topics> viewById(@PathVariable int id) {
		ResponseEntity<Topics> resource=   new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return resource;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics"/*consumes="application/xml"*/)
	public void addTopic(@RequestBody Topics topic) {
		service.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable int id) {
		service.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{id}")
	public void delete(@PathVariable int id) {

		 service.delete(id);
	}
}

