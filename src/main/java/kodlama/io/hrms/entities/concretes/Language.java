package kodlama.io.hrms.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    @NotNull
    @NotBlank
    private String languageName;
    @Column(name = "level")
    @NotNull
    @NotBlank
    private int level;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
