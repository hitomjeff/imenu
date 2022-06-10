package ph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import ph.ctrl.SchoolController;

@SpringBootTest
public class ControllerTest {
	
	@Autowired
	SchoolController schoolCtrl;
	
	// @Test 
	public void contextLoadTest(){
		assertThat(schoolCtrl).isNotNull();
	}

}
