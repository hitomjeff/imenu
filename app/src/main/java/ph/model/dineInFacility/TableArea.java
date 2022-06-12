package ph.model.dineInFacility;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TableArea {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private Boolean isLiquorServed;
}
