package mburakaltun.HRMS.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employer {

    @Column(name = "id")
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "password")
    private String password;
}
