package ph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import ph.model.Student;
import ph.repo.StudentRepo;


@SpringBootTest
public class DataSourceTest {
	
	@Autowired StudentRepo studentRepo;
	
	// @Test 
	public void contextLoadTest(){
		assertThat(this.studentRepo).isNotNull();
	}
	
	/*
	@Test public void ta() {
		Student sa=new Student(null, "tom", "jeff");
		Student saa = studentRepo.save(sa);
		Assert.isTrue(saa.getFn().equals(sa.getFn()));
	}*/

}
