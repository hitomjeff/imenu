package ph;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import ph.model.Student;
import ph.repo.StudentRepo;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DataSourceTest {
	
	@Autowired StudentRepo studentRepo;
	
	
	
	// @Test 
	public void contextLoadTest(){
		assertThat(this.studentRepo).isNotNull();
	}
	
	@BeforeEach public void cleanRepo() {
		studentRepo.deleteAllInBatch();
	}
	
	// @Test 
	public void ta() {
		Student sa=new Student(null, "tom", "jeff", true, 3.22);
		Student saa = studentRepo.save(sa);
		assertThat(sa.getFn()).isEqualTo(saa.getFn());
		
	}

}
