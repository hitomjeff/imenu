package ph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ph.ctrl.SchoolController;
import ph.model.toRm.Course;
import ph.model.toRm.Student;
import ph.repo.CourseRepo;
import ph.repo.StudentRepo;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
//@ActiveProfiles("de")
public class ControllerTest {
	
	static Logger log = LoggerFactory.getLogger(ControllerTest.class);
	
	@Autowired
	SchoolController schoolCtrl;
	
	@Autowired StudentRepo studentRepo;
	@Autowired CourseRepo courseRepo;
	
	@Autowired TestRestTemplate tplt;
	
	// @Autowired MockMvc mockMvc;
	
	@LocalServerPort
	private int port;
	
	@BeforeEach public void cleanRepo() {
		studentRepo.deleteAllInBatch();
		courseRepo.deleteAllInBatch();
	}
	

	@Test 
	public void contextLoadTest(){
		assertThat(schoolCtrl).isNotNull();
		assertThat(studentRepo).isNotNull();
		assertThat(courseRepo).isNotNull();
	}
	
	@Test
	public void testCourse() {
		
		String urlCourse="http://localhost:"+this.port+"/school/course/{id}";
		log.info("course url: "+urlCourse);
		Course c=new Course(null, "math", 4L);
		courseRepo.saveAndFlush(c);
		ResponseEntity<Course> resp = this.tplt.getForEntity(urlCourse, Course.class, 1);
		Course cc = resp.getBody();
		assertThat(cc.getName()).isEqualTo("math");
		
		String urlCourses="http://localhost:"+this.port+"/school/course";
		ResponseEntity<List<Course>> r= this.tplt.exchange(urlCourses, HttpMethod.GET, null, new ParameterizedTypeReference<List<Course>>() {});
		List<Course> cs = r.getBody();
		assertThat(cs.get(0).getName()).isEqualTo("math");
		
		
		
		
	}	
	
	// @Test
	public void sampleEndpointTest() {
		String urlStudents="http://localhost:"+this.port+"/school/student";
		String urlPopulateSample="http://localhost:"+this.port+"/school/sample";
		
		
		
		List<Student> ss= this.tplt.getForObject(urlStudents, java.util.List.class);
		assertThat(ss).isEmpty();
		
		
		ss= this.tplt.getForObject(urlPopulateSample, java.util.List.class);
		assertThat(ss).hasSize(3);
		
		ss= this.tplt.getForObject(urlStudents, java.util.List.class);
		ResponseEntity<List<Student>> respEntity= this.tplt.exchange(urlStudents, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {});
		ss=respEntity.getBody();
		
		assertThat(ss).hasSize(3);
		log.info("elemnents: "+ss.get(0));
		
		ResponseEntity<Student> resp = this.tplt.getForEntity(urlStudents+"/1", Student.class);
		
		long c=this.studentRepo.count();
		assertThat(c).isEqualTo(3);
		
		Student sta=new Student(null, "tom", "jeff", true, 3.23);
		Student stb=ss.get(0);
		assertThat(stb).isEqualToComparingFieldByField(sta);
		
		
	}

}
