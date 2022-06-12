package ph.model.orderServing;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import ph.model.dineInFacility.TableSitting;

@Entity
@Data
public class OrderToken {
	@Id 
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="channelId", referencedColumnName="id")
	private OrderChannel channel;
	
	// Todo: to join to staff table
	private Long staffId;
	
	@ManyToOne
	@JoinColumn(name="sittingTableId", referencedColumnName="id")
	private TableSitting sitting;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderIn, orderOut;
	
	@ManyToOne
	@JoinColumn(name="statusId", referencedColumnName="id")
	private OrderTokenStatus status;

}
