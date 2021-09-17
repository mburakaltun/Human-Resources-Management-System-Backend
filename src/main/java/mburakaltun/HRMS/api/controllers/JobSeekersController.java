package mburakaltun.HRMS.api.controllers;

import mburakaltun.HRMS.business.abstracts.JobSeekerService;
import mburakaltun.HRMS.core.results.DataResult;
import mburakaltun.HRMS.core.results.Result;
import mburakaltun.HRMS.core.results.SuccessDataResult;
import mburakaltun.HRMS.core.results.SuccessResult;
import mburakaltun.HRMS.models.DTOs.JobSeekerCVInfoDTO;
import mburakaltun.HRMS.models.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll() {
        return jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public Result add(JobSeeker jobSeeker) {
        return jobSeekerService.add(jobSeeker);
    }

    @PostMapping("/addEducationalBackgrounds")
    public Result addEducationalBackgrounds(@RequestBody List<JobSeekerEducationalBackground> jobSeekerEducationalBackgrounds, @RequestParam int jobSeekerId) {
        return jobSeekerService.addEducationalBackgrounds(jobSeekerEducationalBackgrounds, jobSeekerId);
    }

    @PostMapping("/addForeignLanguages")
    public Result addForeignLanguages(@RequestBody List<JobSeekerForeignLanguage> foreignLanguages, @RequestParam int jobSeekerId) {
        return jobSeekerService.addForeignLanguages(foreignLanguages, jobSeekerId);
    }

    @PostMapping("/addJobExperiences")
    public Result addJobExperiences(@RequestBody List<JobSeekerJobExperience> jobSeekerJobExperiences, @RequestParam int jobSeekerId) {
        return jobSeekerService.addJobExperiences(jobSeekerJobExperiences, jobSeekerId);
    }

    @PostMapping("/addProgrammingLanguages")
    public Result addProgrammingLanguages(@Valid @RequestBody List<JobSeekerProgrammingLanguage> programmingLanguages, @RequestParam int jobSeekerId) {
        return jobSeekerService.addProgrammingLanguages(programmingLanguages, jobSeekerId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addProfilePicture")
    public Result addProfilePicture(MultipartFile image, @RequestParam int jobSeekerId) throws IOException {
        return jobSeekerService.addProfilePicturePath(image, jobSeekerId);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE, value = "/getProfilePicture")
    public ResponseEntity<ByteArrayResource> getProfilePicture(@RequestParam int jobSeekerId) throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                jobSeekerService.getProfilePicturePath(jobSeekerId).getData())));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);
    }

    @GetMapping("getCVInfo")
    public DataResult<JobSeekerCVInfoDTO> getCVInfo(@RequestParam int jobSeekerId) {
        return jobSeekerService.getCVInfo(jobSeekerId);
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }*/


}
