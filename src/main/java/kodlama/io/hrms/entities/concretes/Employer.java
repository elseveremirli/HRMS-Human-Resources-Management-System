package kodlama.io.hrms.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "e_mail")
    private String email;



}
