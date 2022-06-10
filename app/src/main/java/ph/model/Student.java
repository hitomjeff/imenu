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
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @ToString
public class Student extends Person{
	private Double gpa;
	
	public Student(Long id, String fn, String ln, Boolean gender, Double gpa) {
		super(id, fn, ln, gender);
		this.gpa=gpa;
	}
}
