package kodlama.io.hrms.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="titles")
public class Title {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String name;
	
}
