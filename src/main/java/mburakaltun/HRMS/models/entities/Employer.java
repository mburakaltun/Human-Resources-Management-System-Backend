package mburakaltun.HRMS.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_website")
    private String companyWebsite;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

    public Employer(String companyName, String companyEmail, String companyWebsite, String phoneNumber, String password) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyWebsite = companyWebsite;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Employer() {

    }
}
