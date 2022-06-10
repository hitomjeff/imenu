package ph.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@Data @AllArgsConstructor @NoArgsConstructor
abstract public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id; 
	protected String fn, ln;


}
