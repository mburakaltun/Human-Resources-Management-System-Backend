package mburakaltun.HRMS.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "programming_language")
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class JobSeekerProgrammingLanguage {

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "level")
    @Min(1)
    @Max(5)
    @NotNull
    @NotBlank
    private int level;
}
