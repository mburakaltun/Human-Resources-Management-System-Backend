package mburakaltun.HRMS.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Personal {

    @Column(name = "id")
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;
}
