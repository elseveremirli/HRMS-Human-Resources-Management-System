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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "hrmsAuth","eMailAuth","jobAdvertisements"})
public class Employer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "company_name")
    @NotEmpty
    @NotNull
    private String companyName;
    @Column(name = "web_site")
    @NotEmpty
    @NotNull
    private String webSite;
    @Column(name = "e_mail")
    @NotEmpty
    @NotNull
    @Email
    private String eMail;
    @Column(name = "telephone")
    @NotEmpty
    @NotNull
    private String telephoneNumber;
    @Column(name = "password")
    @NotEmpty
    @NotNull
    private String password;
    @Column(name = "re_password")
    @NotEmpty
    @NotNull
    private String rePassword;
//    @Column(name = "e_mail_auth")
//    private int eMailAuth;
//    @Column(name = "hmrs_auth")
//    private int hrmsAuth;


    @OneToOne()
    @JoinColumn(name = "e_mail_auth")
    private EMailAuth eMailAuth;
    @OneToOne()
    @JoinColumn(name = "hmrs_auth")
    private HrmsAuth hrmsAuth;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean isCredentialsNonExpired;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> authorities ;
}
