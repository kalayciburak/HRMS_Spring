package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobExperienceService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobExperience;
import torukobyte.hrms.entities.dtos.addDtos.JobExperienceAddDto;

import java.util.List;

@RestController
@RequestMapping("/api/jobexperiences")
@CrossOrigin
public class JobExperiencesController {

    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getJobExperienceByCvId")
    public DataResult<List<JobExperience>> getJobExperienceByCvId(@RequestParam int cvId) {
        return this.jobExperienceService.getJobExperienceByCvId(cvId);
    }

    @PostMapping("/addJobExperience")
    public Result addJobExperience(@RequestBody JobExperienceAddDto jobExperience) {
        return this.jobExperienceService.addJobExperience(jobExperience);
    }

    @DeleteMapping("/deleteJobExperienceById")
    public Result deleteJobExperienceById(@RequestParam int id) {
        return this.jobExperienceService.deleteJobExperienceById(id);
    }
}
