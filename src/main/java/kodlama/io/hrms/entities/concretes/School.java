package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "cv"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "school_name")
    @NotNull
    @NotBlank
    private String schoolName;

    @Column(name = "department")
    @NotNull
    @NotBlank
    private String department;

    @Column(name = "entry_date")
    @NotNull
    @NotBlank
    private Date entryDate;

    @Column(name = "graduation_date")
    private Date graduationDate;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;

}
