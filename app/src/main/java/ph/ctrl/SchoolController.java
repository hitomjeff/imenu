package ph.ctrl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ph.model.toRm.Course;
import ph.model.toRm.Student;
import ph.repo.CourseRepo;
import ph.repo.StudentRepo;


@RestController
@RequestMapping("school")
public class SchoolController {
	
	@Autowired 
	private StudentRepo studentRepo;
	
	@Autowired 
	private CourseRepo courseRepo;
	
	@GetMapping("student")	
	public List<Student> getAllStudent(){
		return this.studentRepo.findAll();
	}
	
	@GetMapping("student/{id}")	
	public Optional<Student> getStudent(@PathVariable("id") String id){
		long idl=Long.parseLong(id);
		return this.studentRepo.findById(idl);
	}
	
	
	@GetMapping("stu/{id}")	
	public Optional<Student> getStudentii(@PathVariable("id") long id){
		return this.studentRepo.findById(id);
	}
	
	@GetMapping("sample")
	public List<Student> populateSample(){
		Student sta=new Student(null, "tom", "jeff", true, 3.23);
		Student stb=new Student(null, "gorge", "washington", true, 2.3);
		Student stc=new Student(null, "john", "adams", true, 4.1);
		List<Student> sts = Arrays.asList(sta, stb, stc);
		sts = this.studentRepo.saveAllAndFlush(sts);
		return sts;

	}
	
	@GetMapping("course")
	public List<Course> getAllCourse(){
		return this.courseRepo.findAll();
	}
	
	
	
	@GetMapping("course/{id}")
	public Optional<Course> getAllCourse(@PathVariable("id") long id){
		return this.courseRepo.findById(id);
	}
	
	
	
}
