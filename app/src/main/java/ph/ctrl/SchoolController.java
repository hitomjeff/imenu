package ph.ctrl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ph.model.Student;
import ph.repo.StudentRepo;


@RestController
@RequestMapping("school")
public class SchoolController {
	
	@Autowired 
	private StudentRepo studentRepo;
	
	@GetMapping("student")	
	public List<Student> getAllStudent(){
		return this.studentRepo.findAll();
	}
	
	@GetMapping("sample")
	public List<Student> populateSample(){
		Student sta=new Student(null, "tom", "jeff", 3.23);
		Student stb=new Student(null, "gorge", "washington", 2.3);
		Student stc=new Student(null, "john", "adams", 4.1);
		List<Student> sts = Arrays.asList(sta, stb, stc);
		sts = this.studentRepo.saveAllAndFlush(sts);
		return sts;

	}
	
}
