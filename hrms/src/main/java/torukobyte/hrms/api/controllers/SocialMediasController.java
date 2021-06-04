package torukobyte.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import torukobyte.hrms.business.abstracts.SocialMediaService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialmedias")
public class SocialMediasController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping("/addSocialMedia")
    public Result addSocialMedia(@RequestBody SocialMedia socialMedia) {
        return this.socialMediaService.addSocialMedia(socialMedia);
    }
}
