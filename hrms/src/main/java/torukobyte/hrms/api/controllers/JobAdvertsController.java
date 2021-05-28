package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.JobAdvert;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getjobadverts")
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return this.jobAdvertService.getJobAdverts();
    }

    @PostMapping("/addjobadvert")
    public Result addEmployer(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.addJobAdvert(jobAdvert);
    }
}
