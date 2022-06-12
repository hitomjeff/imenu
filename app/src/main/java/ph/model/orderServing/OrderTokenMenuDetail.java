package ph.model.orderServing;

import java.awt.Menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class OrderTokenMenuDetail {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="kitchenTokenId", referencedColumnName="id")
	private OrderToken token;
	
	@ManyToOne
	@JoinColumn(name="menuId", referencedColumnName="id")
	private Menu menu;
	
	private Integer quantity;
}
