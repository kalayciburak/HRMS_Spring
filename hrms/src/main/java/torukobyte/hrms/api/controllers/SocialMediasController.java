package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.SocialMediaService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.dtos.addDtos.SocialMediaAddDto;

@RestController
@RequestMapping("/api/socialmedias")
@CrossOrigin
public class SocialMediasController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping("/addSocialMedia")
    public Result addSocialMedia(@RequestBody SocialMediaAddDto socialMedia) {
        return this.socialMediaService.addSocialMedia(socialMedia);
    }
}
