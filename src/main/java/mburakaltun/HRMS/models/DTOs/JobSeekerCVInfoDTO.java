package mburakaltun.HRMS.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mburakaltun.HRMS.models.entities.JobSeekerEducationalBackground;
import mburakaltun.HRMS.models.entities.JobSeekerForeignLanguage;
import mburakaltun.HRMS.models.entities.JobSeekerJobExperience;
import mburakaltun.HRMS.models.entities.JobSeekerProgrammingLanguage;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCVInfoDTO {
    private String name;

    private String surname;

    private String idNo;

    private String birthdate;

    private String email;

    private String linkedinUrl;

    private String githubUrl;

    private String coverLetter;

    private List<JobSeekerEducationalBackground> educationalBackgrounds;

    private List<JobSeekerForeignLanguage> foreignLanguages;

    private List<JobSeekerJobExperience> jobExperiences;

    private List<JobSeekerProgrammingLanguage> programmingLanguages;
}
