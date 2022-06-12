package ph.model.orderServing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderTokenStatus {
	@Id
	@GeneratedValue
	private Long id;

	private String status;
}
