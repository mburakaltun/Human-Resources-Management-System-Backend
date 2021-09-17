package mburakaltun.HRMS.business.abstracts;

import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.models.entities.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    DataResult<JobSeeker> getByEmail(String email);
    DataResult<JobSeeker> getByIdNo(String idNo);
    Result addEducationalBackgrounds(List<JobSeekerEducationalBackground> jobSeekerEducationalBackgrounds, int jobSeekerId);
    Result addForeignLanguages(List<JobSeekerForeignLanguage> foreignLanguages, int jobSeekerId);
    Result addJobExperiences(List<JobSeekerJobExperience> jobSeekerJobExperiences, int jobSeekerId);
    Result addProgrammingLanguages(List<JobSeekerProgrammingLanguage> programmingLanguages, int jobSeekerId);
    Result addProfilePicturePath(MultipartFile image, int jobSeekerId) throws IOException;
    DataResult<String> getProfilePicturePath(int jobSeekerId);
}
