package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
    Result addSocialMedia(SocialMedia socialMedia);

}
