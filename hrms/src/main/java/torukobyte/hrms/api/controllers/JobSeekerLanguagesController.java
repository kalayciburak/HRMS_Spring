package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobSeekerLanguageService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

@RestController
@RequestMapping("/api/jobseekerLanguages")
@CrossOrigin
public class JobSeekerLanguagesController {
    private final JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @PostMapping("/addJobseekerLanguages")
    public Result addJobseekerLanguage(@RequestBody JobSeekerLanguageAddDto jobSeekerLanguage) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
    }
}
