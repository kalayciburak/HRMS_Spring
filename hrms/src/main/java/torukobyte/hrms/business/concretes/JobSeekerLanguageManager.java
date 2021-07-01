package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobSeekerLanguageService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import torukobyte.hrms.entities.concretes.JobSeekerLanguage;
import torukobyte.hrms.entities.dtos.addDtos.JobSeekerLanguageAddDto;

import java.util.List;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private final JobSeekerLanguageDao jobSeekerLanguageDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobSeekerLanguageManager(
            JobSeekerLanguageDao jobSeekerLanguageDao,
            DtoConverterService dtoConverterService) {
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addJobSeekerLanguage(JobSeekerLanguageAddDto jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save((JobSeekerLanguage) this.dtoConverterService.dtoClassConverter(
                jobSeekerLanguage,
                JobSeekerLanguage.class));
        return new SuccessResult("Success: Cv'ye başarıyla yabancı dil bilgisi eklendi!");
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getJobSeekerLanguageByCurriculaVitaeId(int id) {
        if (this.jobSeekerLanguageDao.getJobSeekerLanguageByCurriculaVitaeId(id).isEmpty()) {
            return new WarningDataResult<>("Warning: Listelenecek yabancı dil bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.jobSeekerLanguageDao.getJobSeekerLanguageByCurriculaVitaeId(id),
                    "Success: Yabancı diller başarıyla listelendi!");
        }
    }
}
