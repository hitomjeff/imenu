package ph.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data @NoArgsConstructor 
public class Student extends Person{
	private Double gpa;
	
	public Student(Long id, String fn, String ln, Double gpa) {
		super(id, fn, ln);
		this.gpa=gpa;
	}
}
