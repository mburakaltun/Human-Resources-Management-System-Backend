package mburakaltun.HRMS.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "job_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerId"})
public class JobSeekerJobExperience {

    @NotNull
    @NotBlank
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name = "department")
    private String department;

    @NotNull
    @NotBlank
    @Column(name = "entrance_year")
    private int entranceYear;

    @Column(name = "termination_year")
    private int terminationYear;
}
