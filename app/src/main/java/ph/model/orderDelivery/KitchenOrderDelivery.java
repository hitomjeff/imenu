package ph.model.orderDelivery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import ph.model.orderServing.OrderTokenMenuDetail;

@Entity
@Data
public class KitchenOrderDelivery {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="tokenMenuId", referencedColumnName="id")
	private OrderTokenMenuDetail orderMenuItem;
	
	// TODO: staff table connection
	private Long staffId;
	
	@ManyToOne
	@JoinColumn(name="statusId", referencedColumnName="id")
	private DeliveryStatus status;
}
