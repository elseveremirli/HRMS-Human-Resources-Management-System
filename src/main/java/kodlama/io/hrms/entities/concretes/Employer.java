package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "hrmsAuth","eMailAuth"})
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "e_mail")
    private String eMail;
    @Column(name = "telephone")
    private String telephoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "re_password")
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



}
