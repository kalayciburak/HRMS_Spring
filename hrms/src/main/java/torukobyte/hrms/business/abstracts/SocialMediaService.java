package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.dtos.addDtos.SocialMediaAddDto;

public interface SocialMediaService {
    Result addSocialMedia(SocialMediaAddDto socialMedia);

}
