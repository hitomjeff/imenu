package ph.model.dineInFacility;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class TableSitting {
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date dineIn, dineOut; 
	
	private int numCustomer;
	
	@ManyToOne
	@JoinColumn(name="tableId", referencedColumnName="id")
	private DineTable dineTable;
}
