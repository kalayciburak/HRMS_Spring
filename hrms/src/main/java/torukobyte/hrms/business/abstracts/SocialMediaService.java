package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SocialMedia;
import torukobyte.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import torukobyte.hrms.entities.dtos.updateDtos.SocialMediaUpdateDto;

public interface SocialMediaService {
    Result addSocialMedia(SocialMediaAddDto socialMedia);

    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);

    DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id);

}
