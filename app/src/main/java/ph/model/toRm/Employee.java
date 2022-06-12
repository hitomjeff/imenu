package ph.model.toRm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long id; 
}
