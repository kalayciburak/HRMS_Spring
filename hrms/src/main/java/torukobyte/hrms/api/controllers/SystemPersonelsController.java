package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.business.abstracts.SystemPersonelService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SystemPersonel;

import java.util.List;

@RestController
@RequestMapping("/api/systemPersonels")
@CrossOrigin
public class SystemPersonelsController {

    private final SystemPersonelService systemPersonelService;

    private final JobAdvertService jobAdvertService;

    @Autowired
    public SystemPersonelsController(SystemPersonelService systemPersonelService, JobAdvertService jobAdvertService) {
        this.systemPersonelService = systemPersonelService;
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getSystemPersonels")
    public DataResult<List<SystemPersonel>> getSystemPersonels() {
        return this.systemPersonelService.getSystemPersonels();
    }

    @GetMapping("/getSystemPersonelById")
    public DataResult<SystemPersonel> getSystemPersonelById(int systemPersonelId) {
        return this.systemPersonelService.getSystemPersonelById(systemPersonelId);
    }

    @DeleteMapping("/deleteSystemPersonelById")
    public Result deleteSystemPersonelById(@RequestParam int systemPersonelId) {
        return this.systemPersonelService.deleteSystemPersonelById(systemPersonelId);
    }

    @PostMapping("/addSystemPersonel")
    public Result addSystemPersonel(@RequestBody SystemPersonel systemPersonel) {
        return this.systemPersonelService.addSystemPersonel(systemPersonel);
    }

    @PostMapping("/changeIsConfirmed")
    public Result changeIsConfirmed(@RequestParam boolean confirm, int jobAdvertId) {
        return this.jobAdvertService.changeIsConfirmed(confirm, jobAdvertId);
    }


}
