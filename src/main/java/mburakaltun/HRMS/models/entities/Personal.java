package mburakaltun.HRMS.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personals")
public class Personal {

    @Column(name = "id")
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;
}
