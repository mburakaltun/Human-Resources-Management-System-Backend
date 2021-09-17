package mburakaltun.HRMS.business.concretes;

import mburakaltun.HRMS.business.abstracts.JobSeekerService;
import mburakaltun.HRMS.core.results.*;
import mburakaltun.HRMS.dataAccess.JobSeekerDAO;
import mburakaltun.HRMS.models.DTOs.JobSeekerCVInfoDTO;
import mburakaltun.HRMS.models.entities.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDAO jobSeekerDAO;

    @Autowired
    public JobSeekerManager(JobSeekerDAO jobSeekerDAO) {
        this.jobSeekerDAO = jobSeekerDAO;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDAO.findAll(), "Job Seekers listed successfully");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        jobSeekerDAO.saveAndFlush(jobSeeker);
        return new SuccessResult("Job Seeker successfully added to the system.");
    }

    @Override
    public DataResult<JobSeeker> getByEmail(String email) {
        return new SuccessDataResult<>(jobSeekerDAO.findByEmail(email));
    }

    @Override
    public DataResult<JobSeeker> getByIdNo(String idNo) {
        return new SuccessDataResult<>(jobSeekerDAO.findByIdNo(idNo));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Result addEducationalBackgrounds(List<JobSeekerEducationalBackground> jobSeekerEducationalBackgrounds, int jobSeekerId) {
        JobSeeker jobSeeker = jobSeekerDAO.getById(jobSeekerId);
        jobSeeker.addListOfEducationalBackgrounds(jobSeekerEducationalBackgrounds);
        jobSeekerDAO.save(jobSeeker);
        return new SuccessResult("Educational backgrounds added");
    }

    @Override
    public Result addForeignLanguages(List<JobSeekerForeignLanguage> foreignLanguages, int jobSeekerId) {
        JobSeeker jobSeeker = jobSeekerDAO.getById(jobSeekerId);
        jobSeeker.addListOfForeignLanguages(foreignLanguages);
        jobSeekerDAO.save(jobSeeker);
        return new SuccessResult("Foreign languages added");
    }

    @Override
    public Result addJobExperiences(List<JobSeekerJobExperience> jobSeekerJobExperiences, int jobSeekerId) {
        JobSeeker jobSeeker = jobSeekerDAO.getById(jobSeekerId);
        jobSeeker.addListOfJobExperiences(jobSeekerJobExperiences);
        jobSeekerDAO.save(jobSeeker);
        return new SuccessResult("Job experiences added");
    }

    @Override
    public Result addProgrammingLanguages(List<JobSeekerProgrammingLanguage> programmingLanguages, int jobSeekerId) {
        JobSeeker jobSeeker = jobSeekerDAO.getById(jobSeekerId);
        jobSeeker.addListOfProgrammingLanguages(programmingLanguages);
        jobSeekerDAO.save(jobSeeker);
        return new SuccessResult("Programming languages added");
    }

    @Override
    public Result addProfilePicturePath(MultipartFile image, int jobSeekerId) throws IOException {
        Optional<JobSeeker> jobSeeker = jobSeekerDAO.findById(jobSeekerId);
        if (!jobSeeker.isPresent()) {
            return new ErrorResult("No user found by id " + jobSeekerId);
        }
        byte[] bytes = image.getBytes();
        Path path = Paths.get("src/main/resources/static/" + jobSeekerId + "/" + image.getOriginalFilename());
        File directory = new File("src/main/resources/static/" + jobSeekerId + "/");
        if (!directory.exists()) {
            directory.mkdir();
        } else {
            FileUtils.cleanDirectory(directory);
        }
        Files.write(path, bytes);
        jobSeeker.get().setProfilePicturePath(path.toString());
        jobSeekerDAO.save(jobSeeker.get());
        return new SuccessResult();
    }

    @Override
    public DataResult<String> getProfilePicturePath(int jobSeekerId) {
        return new SuccessDataResult<>(jobSeekerDAO.getById(jobSeekerId).getProfilePicturePath());
    }

    @Override
    public DataResult<JobSeekerCVInfoDTO> getCVInfo(int jobSeekerId) {
        JobSeekerCVInfoDTO jobSeekerCVInfoDTO = new JobSeekerCVInfoDTO(
                jobSeekerDAO.getById(jobSeekerId).getName(),
                jobSeekerDAO.getById(jobSeekerId).getSurname(),
                jobSeekerDAO.getById(jobSeekerId).getIdNo(),
                jobSeekerDAO.getById(jobSeekerId).getBirthdate(),
                jobSeekerDAO.getById(jobSeekerId).getEmail(),
                jobSeekerDAO.getById(jobSeekerId).getLinkedinUrl(),
                jobSeekerDAO.getById(jobSeekerId).getGithubUrl(),
                jobSeekerDAO.getById(jobSeekerId).getCoverLetter(),
                jobSeekerDAO.getById(jobSeekerId).getEducationalBackgrounds(),
                jobSeekerDAO.getById(jobSeekerId).getForeignLanguages(),
                jobSeekerDAO.getById(jobSeekerId).getJobExperiences(),
                jobSeekerDAO.getById(jobSeekerId).getProgrammingLanguages()
        );
        return new SuccessDataResult<>(jobSeekerCVInfoDTO);
    }
}
