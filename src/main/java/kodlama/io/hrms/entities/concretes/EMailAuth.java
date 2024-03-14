package kodlama.io.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Table(name = "e_mail_auths")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "candidate","employer"})
public class EMailAuth {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "verified_date")
    private Date verifiedDate;

    @OneToOne(mappedBy = "eMailAuth")
    private Candidate candidate;

    @OneToOne(mappedBy = "eMailAuth")
    private Employer employer;
}
