package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.SocialMediaService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.core.utilities.results.SuccessResult;
import torukobyte.hrms.dataAccess.abstracts.SocialMediaDao;
import torukobyte.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

    private final SocialMediaDao socialMediaDao;

    @Autowired
    public SocialMediaManager(SocialMediaDao socialMediaDao) {
        this.socialMediaDao = socialMediaDao;
    }

    @Override
    public Result addSocialMedia(SocialMedia socialMedia) {
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult("Sosyal medya bağlantıları başarıyla sisteme eklendi!");
    }
}
