package ph.model.menu;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data 
public class Menu {
	@Id
	@GeneratedValue
	private Long id;
	private String name, description, imagePath;
	
	@ManyToOne
	@JoinColumn(name = "catagoryId", referencedColumnName = "id")
	private Catagory catagory;
	private Integer cost;
}
