package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobSeekerLanguageService;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.core.utilities.results.SuccessResult;
import torukobyte.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private final JobSeekerLanguageDao jobSeekerLanguageDao;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult("Success: Cv'ye başarıyla yabancı dil bilgisi eklendi!");
    }
}
