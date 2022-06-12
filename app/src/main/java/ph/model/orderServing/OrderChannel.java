package ph.model.orderServing;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class OrderChannel {
	@Id
	@GeneratedValue
	private Long id;
	private String name, description;
	
	@Temporal(TemporalType.TIME)
	private Date open, close;
	
}
