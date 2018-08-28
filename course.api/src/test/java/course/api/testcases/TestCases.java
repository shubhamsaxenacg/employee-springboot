package course.api.testcases;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.javabrains.springbootstarter.dao.CustomRepository;
import io.javabrains.springbootstarter.pojo.Topics;
import io.javabrains.springbootstarter.service.TopicService;
import io.javabrains.springbootstarter.topic.TopicController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootConfiguration
																		
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCases {

	private MockMvc mockMvc;
	
	@InjectMocks
	private TopicController controller;
	
	@Before
	public void setup() throws Exception
	
	{
		mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
		System.out.println("fghfhg");
		
	}
	@Mock
	private TopicService service;
	
	@Mock
	private CustomRepository dao;
	
	//Topics mockCourse = new Topics(1,"aashish","hibis");
	
	@Test
	public void testviewAll() throws Exception {
		mockMvc.perform(get("/topics")).andExpect(status().isOk()).andExpect(content().string("[]"));
	}
	
	@Test
	public void testViewCustomer() throws Exception {
		mockMvc.perform(get("/topics/1")).andExpect(status().isFound());
	}
}