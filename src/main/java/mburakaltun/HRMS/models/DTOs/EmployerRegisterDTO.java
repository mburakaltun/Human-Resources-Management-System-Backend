package mburakaltun.HRMS.models.DTOs;


public class EmployerRegisterDTO {

    private String companyName;
    private String companyWebsite;
    private String companyEmail;
    private String phoneNumber;
    private String password;

    public EmployerRegisterDTO(String companyName, String companyWebsite, String companyEmail, String phoneNumber, String password) {
        this.companyName = companyName;
        this.companyWebsite = companyWebsite;
        this.companyEmail = companyEmail;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
