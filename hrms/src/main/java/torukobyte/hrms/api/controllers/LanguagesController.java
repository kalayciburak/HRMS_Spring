package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.LanguageService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.entities.concretes.Language;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getLanguages")
    public DataResult<List<Language>> getLanguages() {
        return this.languageService.getLanguages();
    }

    @PostMapping("/addLanguages")
    public DataResult<List<Language>> addLanguages(@RequestBody List<Language> languages) {
        return this.languageService.addLanguages(languages);
    }
}
