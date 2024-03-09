package kodlama.io.hrms.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "e_mail_auths")
@AllArgsConstructor
@NoArgsConstructor
public class EMailAuth {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "verified_date")
    private Date verifiedDate;

}
