package ph.model.menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Catagory {
	@Id
	@GeneratedValue
	private Long id;
	private String name, description;
	
}
