package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name= "job_advertisement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "employer"})
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;
    @Column(name = "open_position")
    private int openPosition;
    @Column(name = "application_deadline")
    private Date applicationDeadline;
    @Column(name = "is_open")
    private boolean isOpen;
    @Column(name = "job_desc")
    private String jobDesc;
    @Column(name = "city")
    private String city;

    @ManyToOne()
    @JoinColumn(name = "company")
    private Employer employer;
}
