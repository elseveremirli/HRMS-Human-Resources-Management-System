package kodlama.io.hrms.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;
    @Column(name = "position")
    @NotBlank
    @NotNull
    private String position;
    @Column(name = "entry_date")
    @NotBlank
    @NotNull
    private Date entryDate;

    @Column(name = "quit_date")
    private Date quitDate;

    @ManyToOne()
    @Column(name = "cv_id")
    private Cv cv;



}
