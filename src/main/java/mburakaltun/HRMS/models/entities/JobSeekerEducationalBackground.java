package mburakaltun.HRMS.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "educational_background")
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerId"})
public class JobSeekerEducationalBackground {

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "department")
    private String department;

    @NotNull
    @NotBlank
    @Column(name = "entrance_year")
    private int entranceYear;


    @Column(name = "graduation_year")
    private int graduationYear;
}
