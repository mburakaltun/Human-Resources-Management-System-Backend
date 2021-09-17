package mburakaltun.HRMS.models.DTOs;

import lombok.Data;

@Data
public class JobSeekerRegisterDTO {
    private String name;
    private String surname;
    private String idNo;
    private String birthdate;
    private String email;
    private String password;
    private String reenteredPassword;
}
