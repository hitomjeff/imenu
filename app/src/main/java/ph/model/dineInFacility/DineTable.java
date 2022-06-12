package ph.model.dineInFacility;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class DineTable {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="areaId", referencedColumnName="id")
	private TableArea area;
	
	private Integer servingCapacity;
	
	// TODO: might need and schedule ER (staffId - tableId ) to  
	private Long servingStaffId;
	
	@ManyToOne
	@JoinColumn(name="tableStatusId", referencedColumnName="id")
	private TableStatus status;

}
