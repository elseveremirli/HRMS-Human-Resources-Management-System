package kodlama.io.hrms.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "national_id", unique = true)
    private String nationalId;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "e_mail", unique = true)
    private String eMail;
    @Column(name = "password")
    private String password;
    @Column(name = "re_password")
    private String rePassword;
    @Column(name = "mernis_auth", unique = true)
    private int mernisAuth;
    @Column(name = "e_mail_auth", unique = true)
    private int eMailAuth;

}
