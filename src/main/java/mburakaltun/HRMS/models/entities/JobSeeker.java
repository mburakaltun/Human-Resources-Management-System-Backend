package mburakaltun.HRMS.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_seekers")
public class JobSeeker {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "id_no")
    private String idNo;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public JobSeeker(String name, String surname, String idNo, String birthdate, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.idNo = idNo;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }

    public JobSeeker() {

    }
}
