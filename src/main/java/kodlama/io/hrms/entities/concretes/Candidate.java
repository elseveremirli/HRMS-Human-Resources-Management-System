package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "mernisAuth","eMailAuth","cvs"})
public class Candidate implements UserDetails {

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
    @Column(name = "username")
    private String username;
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

    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean isCredentialsNonExpired;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> authorities ;


//    @OneToMany(mappedBy = "candidate")
//    private List<Cv> cvs;

}
