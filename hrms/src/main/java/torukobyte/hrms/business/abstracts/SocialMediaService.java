package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.SocialMedia;
import torukobyte.hrms.entities.dtos.addDtos.SocialMediaAddDto;
import torukobyte.hrms.entities.dtos.ıpdateDtos.SocialMediaUpdateDto;

import java.util.List;

public interface SocialMediaService {
    Result addSocialMedia(SocialMediaAddDto socialMedia);

    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);

    DataResult<List<SocialMedia>> getSocialMediaByCurriculaVitaeId(int id);

}
