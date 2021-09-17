package mburakaltun.HRMS.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Table(name = "foreign_languages")
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerId"})
public class JobSeekerForeignLanguage {

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
