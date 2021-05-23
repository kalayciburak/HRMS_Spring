package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import torukobyte.hrms.business.abstracts.JobPositionService;
import torukobyte.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getpositions")
    public List<JobPosition> getPositions() {
        return this.jobPositionService.getPositions();
    }
}
