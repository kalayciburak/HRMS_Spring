package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.ProgrammingLanguageService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.ProgrammingLanguage;

import java.util.List;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {

    private final ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/getProgrammingLanguages")
    public DataResult<List<ProgrammingLanguage>> getProgrammingLanguages() {
        return this.programmingLanguageService.getAllProgrammingLanguage();
    }

    @PostMapping("/addProgrammingLanguage")
    public Result addProgrammingLanguage(@RequestBody ProgrammingLanguage pl) {
        return this.programmingLanguageService.addProgrammingLanguage(pl);
    }
}
