package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobExperienceService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobExperience;

import java.util.List;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {

    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getSortedJobExperiences")
    public DataResult<List<JobExperience>> getSortedJobExperiences(@RequestParam int cvId) {
        return this.jobExperienceService.findAllSorted(cvId);
    }

    @PostMapping("/addJobExperience")
    public Result addJobExperience(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.addJobExperience(jobExperience);
    }
}
