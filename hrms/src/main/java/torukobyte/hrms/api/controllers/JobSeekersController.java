package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobSeekerService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobSeeker;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getJobseekers")
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return this.jobSeekerService.getJobSeekers();
    }

    @PostMapping("/addJobseeker")
    public Result addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.addJobSeeker(jobSeeker);
    }


}
