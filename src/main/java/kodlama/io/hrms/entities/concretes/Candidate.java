package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "candidates")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "mernisAuth","eMailAuth"})
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;


    @Column(name = "surname")
    @NotNull
    @NotEmpty
    private String surname;

    @Column(name = "national_id", unique = true)
    @NotNull
    @NotEmpty
    private String nationalId;

    @Column(name = "birth_date")
    @NotNull
    @NotEmpty
    private Date birthDate;

    @Column(name = "e_mail", unique = true)
    @NotNull
    @NotEmpty
    @Email
    private String eMail;

    @Column(name = "password")
    @NotNull
    @NotEmpty
    private String password;

    @Column(name = "re_password")
    @NotNull
    @NotEmpty
    private String rePassword;
//    @Column(name = "mernis_auth", unique = true)
//    private int mernisAuth;
//    @Column(name = "e_mail_auth", unique = true)
//    private int eMailAuth;


    @OneToOne()
    @JoinColumn(name = "mernis_auth",referencedColumnName = "id")
    private MernisAuth mernisAuth;

    @OneToOne()
    @JoinColumn(name = "e_mail_auth",referencedColumnName = "id")

    private EMailAuth eMailAuth;


    @OneToMany(mappedBy = "candidate")
    private List<Cv> cvs;

}
