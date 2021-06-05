package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import torukobyte.hrms.business.abstracts.JobSeekerLanguageService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerLanguages")
public class JobSeekerLanguagesController {
    private final JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @PostMapping("/addJobseekerLanguages")
    public Result addJobseekerLanguage(@RequestBody JobSeekerLanguage jobSeekerLanguage) {
        return this.jobSeekerLanguageService.addJobSeekerLanguage(jobSeekerLanguage);
    }
}