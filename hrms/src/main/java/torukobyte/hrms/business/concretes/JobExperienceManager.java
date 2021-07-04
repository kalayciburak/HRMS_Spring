package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobExperienceService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.JobExperienceDao;
import torukobyte.hrms.entities.concretes.JobExperience;
import torukobyte.hrms.entities.dtos.addDtos.JobExperienceAddDto;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addJobExperience(JobExperienceAddDto jobExperience) {
        this.jobExperienceDao.save((JobExperience) this.dtoConverterService.dtoClassConverter(
                jobExperience,
                JobExperience.class));
        return new SuccessResult("Success: Kariyer bilgisi başarıyla sisteme eklendi!");
    }

    @Override
    public DataResult<List<JobExperience>> getJobExperienceByCvId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        if (this.jobExperienceDao.getJobExperienceEndDateByCurriculaVitaeId(id, sort).isEmpty()) {
            return new WarningDataResult<>("Warning: Listelenecek iş tecrübesi bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.jobExperienceDao.getJobExperienceEndDateByCurriculaVitaeId(id, sort),
                    "Success: İş tecrübeleri başarıyla sıralanıp listelendi!");
        }
    }

    @Override
    public Result deleteJobExperienceById(int id) {
        this.jobExperienceDao.deleteJobExperienceById(id);
        return new SuccessResult("Success: İş geçmişi silindi!");
    }
}
