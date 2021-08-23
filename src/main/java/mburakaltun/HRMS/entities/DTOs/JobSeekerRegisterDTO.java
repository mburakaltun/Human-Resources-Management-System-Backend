package mburakaltun.HRMS.entities.DTOs;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class JobSeekerRegisterDTO {
    private int id;
    private String name;
    private String surname;
    private String idNo;
    private String birthdate;
    private String email;
    private String password;
    private String reenteredPassword;
}
