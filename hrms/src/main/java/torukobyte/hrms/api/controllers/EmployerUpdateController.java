package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.EmployerUpdateService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.EmployerUpdate;

@RestController
@RequestMapping("/api/employersUpdate")
@CrossOrigin
public class EmployerUpdateController {
    private final EmployerUpdateService employerUpdateService;

    @Autowired
    public EmployerUpdateController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("/getByEmployerUpdateId")
    public DataResult<EmployerUpdate> getEmployerById(int employerId) {
        return this.employerUpdateService.getEmployerUpdateById(employerId);
    }

    @DeleteMapping("/deleteEmployerUpdateById")
    public Result deleteEmployerById(@RequestParam int employerId) {
        return this.employerUpdateService.deleteEmployerUpdateById(employerId);
    }

    @PostMapping("/addEmployerUpdate")
    public Result addEmployerUpdate(@RequestBody EmployerUpdate employerUpdate) {
        return this.employerUpdateService.addEmployerUpdate(employerUpdate);
    }
}
