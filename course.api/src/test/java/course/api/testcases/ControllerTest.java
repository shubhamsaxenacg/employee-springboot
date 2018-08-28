/*package course.api.testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.javabrains.springbootstarter.pojo.Topics;
import io.javabrains.springbootstarter.service.TopicService;
import io.javabrains.springbootstarter.topic.TopicController;

@SpringBootConfiguration
@RunWith(SpringRunner.class)
//@WebMvcTest(value = TopicController.class, secure = false)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TopicService topicService;

	Topics mockCourse = new Topics(1,"Aashish","adlkfj");

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\"]}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				topicService.viewById(Mockito.anyInt())).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/topics/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,name:Aashish,desc:adlkfj}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
*/