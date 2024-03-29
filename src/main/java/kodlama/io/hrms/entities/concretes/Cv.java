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
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name="technologies")
    private String technologies;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToMany(mappedBy = "cv")
    @JsonBackReference
    private List<School> schools;

    @OneToMany(mappedBy = "cv", targetEntity = JobExperience.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv")
    @JsonBackReference
    private List<Language> languages;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
