package mburakaltun.HRMS.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.nio.file.Path;
import java.util.List;

@Data
@Entity
@Table(name = "job_seekers")
public class JobSeeker {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "username")
    @Size(min = 8, max = 30)
    private String username;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @NotNull
    @NotBlank
    @Column(name = "id_no")
    private String idNo;

    @NotNull
    @NotBlank
    @Column(name = "birthdate")
    private String birthdate;

    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "password")
    @Size(min = 8, max = 30)
    private String password;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "profile_picture_path")
    private String profilePicturePath;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "educational_background", joinColumns = @JoinColumn(name = "job_seeker_id"))
    private List<JobSeekerEducationalBackground> educationalBackgrounds;

    @ElementCollection
    @CollectionTable(name = "foreign_language", joinColumns = @JoinColumn(name = "job_seeker_id"))
    private List<JobSeekerForeignLanguage> foreignLanguages;

    @ElementCollection
    @CollectionTable(name = "job_experience", joinColumns = @JoinColumn(name = "job_seeker_id"))
    private List<JobSeekerJobExperience> jobExperiences;

    @ElementCollection
    @CollectionTable(name = "programming_language", joinColumns = @JoinColumn(name = "job_seeker_id"))
    private List<JobSeekerProgrammingLanguage> programmingLanguages;

    public JobSeeker(String name, String surname, String idNo, String birthdate, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.idNo = idNo;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }

    public JobSeeker() {

    }

    public void addListOfEducationalBackgrounds(List<JobSeekerEducationalBackground> educationalBackgroundList) {
        educationalBackgrounds.addAll(educationalBackgroundList);
    }

    public void addEducationalBackground(JobSeekerEducationalBackground educationalBackground) {
        educationalBackgrounds.add(educationalBackground);
    }

    public void addListOfForeignLanguages(List<JobSeekerForeignLanguage> foreignLanguageList) {
        foreignLanguages.addAll(foreignLanguageList);
    }

    public void addListOfProgrammingLanguages(List<JobSeekerProgrammingLanguage> programmingLanguageList) {
        programmingLanguages.addAll(programmingLanguageList);
    }

    public void addListOfJobExperiences(List<JobSeekerJobExperience> jobSeekerJobExperienceList) {
        jobExperiences.addAll(jobSeekerJobExperienceList);
    }


}
