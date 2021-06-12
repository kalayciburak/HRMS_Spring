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
@CrossOrigin
public class JobAdvertsController {
    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getJobAdverts")
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return this.jobAdvertService.getJobAdverts();
    }

    @GetMapping("/getActiveJobAdverts")
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        return this.jobAdvertService.getActiveJobAdverts();
    }

    @GetMapping("/getJobAdvertByCompanyName")
    public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
        return this.jobAdvertService.getJobAdvertByCompanyName(companyName);
    }

    @GetMapping("/getActiveJobAdvertsSorted")
    public DataResult<List<JobAdvert>> findAllByIsActiveTrueSorted() {
        return this.jobAdvertService.findAllByIsActiveTrue();
    }

    @GetMapping("/getJobAdvertByIsActiveTrueAndIsConfirmedTrue")
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
        return this.jobAdvertService.getJobAdvertByIsActiveTrueAndIsConfirmedTrue();
    }

    @GetMapping("/getJobAdvertById")
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId) {
        return this.jobAdvertService.getJobAdvertById(jobAdvertId);
    }

    @DeleteMapping("/deleteJobAdvertById")
    public Result deleteJobAdvertById(@RequestParam int jobAdvertId) {
        return this.jobAdvertService.deleteJobAdvertById(jobAdvertId);
    }

    @PostMapping("/addJobadvert")
    public Result addJobAdverts(@RequestBody JobAdvert jobAdvert) {
        return this.jobAdvertService.addJobAdvert(jobAdvert);
    }

}
