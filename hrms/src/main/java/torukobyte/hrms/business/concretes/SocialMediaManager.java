package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.SocialMediaService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.core.utilities.results.SuccessResult;
import torukobyte.hrms.dataAccess.abstracts.SocialMediaDao;
import torukobyte.hrms.entities.concretes.SocialMedia;
import torukobyte.hrms.entities.dtos.addDtos.SocialMediaAddDto;

@Service
public class SocialMediaManager implements SocialMediaService {

    private final SocialMediaDao socialMediaDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao, DtoConverterService dtoConverterService) {
        this.socialMediaDao = socialMediaDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addSocialMedia(SocialMediaAddDto socialMedia) {
        this.socialMediaDao.save((SocialMedia) this.dtoConverterService.dtoClassConverter(
                socialMedia,
                SocialMedia.class));
        return new SuccessResult("Success: Sosyal medya bağlantıları başarıyla sisteme eklendi!");
    }
}
