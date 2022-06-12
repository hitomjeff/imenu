package ph.model.toRm;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor 
public class Teacher extends Person{
	private String title;
	private String cv;
	public Teacher(Long id, String fn, String ln, String title, String cv, Boolean gender) {
		super(id, fn, ln, gender);
		this.title=title;
		this.cv=cv;
	}
	
}
