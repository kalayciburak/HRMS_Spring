package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.SocialMediaService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SocialMedia;
import torukobyte.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import torukobyte.hrms.entities.dtos.ıpdateDtos.SocialMediaUpdateDto;

@RestController
@RequestMapping("/api/socialmedias")
@CrossOrigin
public class SocialMediasController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getSocialMediaByCurriculaVitaeId")
    public DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(@RequestParam int cvId) {
        return this.socialMediaService.getSocialMediaByCurriculaVitaeId(cvId);
    }

    @PostMapping("/addSocialMedia")
    public Result addSocialMedia(@RequestBody SocialMediaAddDto socialMedia) {
        return this.socialMediaService.addSocialMedia(socialMedia);
    }

    @PutMapping("/updateSocialMedia")
    public Result updateSocialMedia(@RequestBody SocialMediaUpdateDto socialMedia) {
        return this.socialMediaService.updateSocialMedia(socialMedia);
    }
}
