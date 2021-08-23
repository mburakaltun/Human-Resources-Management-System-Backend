package mburakaltun.HRMS.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class JobSeeker {

    @Column(name = "id")
    @Id
    @GeneratedValue
    private int id;

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
}
