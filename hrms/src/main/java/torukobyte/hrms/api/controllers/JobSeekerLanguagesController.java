package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobSeekerLanguageService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;
import torukobyte.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekerLanguages")
@CrossOrigin
public class JobSeekerLanguagesController {
    private final JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @GetMapping("/getJobseekerLanguagesByCvId")
    public DataResult<List<JobSeekerLanguage>> getJobseekerLanguagesByCvId(@RequestParam int cvId) {
        return this.jobSeekerLanguageService.getJobSeekerLanguageByCurriculaVitaeId(cvId);
    }

    @PostMapping("/addJobseekerLanguages")
    public Result addJobseekerLanguage(@RequestBody JobSeekerLanguageAddDto jobSeekerLanguage) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
    }

    @DeleteMapping("/deleteJobSeekerLanguageById")
    public Result deleteJobSeekerLanguageById(@RequestParam int id) {
        return this.jobSeekerLanguageService.deleteJobSeekerLanguageById(id);
    }
}
