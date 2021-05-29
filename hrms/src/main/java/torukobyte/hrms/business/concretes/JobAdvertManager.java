package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.core.utilities.results.SuccessDataResult;
import torukobyte.hrms.core.utilities.results.SuccessResult;
import torukobyte.hrms.dataAccess.abstracts.JobAdvertsDao;
import torukobyte.hrms.entities.concretes.JobAdvert;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {
    private final JobAdvertsDao jobAdvertsDao;

    @Autowired
    public JobAdvertManager(JobAdvertsDao jobAdvertsDao) {
        this.jobAdvertsDao = jobAdvertsDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdverts() {
        return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "Success: İlanlar listelendi.");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        return new SuccessDataResult<>(this.jobAdvertsDao.findAllByIsActiveTrue(), "Aktif tüm iş ilanları listelendi!");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdvertsSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "airdate");
        return new SuccessDataResult<>(this.jobAdvertsDao.findAll(sort), "Aktif tüm iş ilanları listelendi!");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName) {
        return new SuccessDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName),
                "Success: Şirket'e ait tüm ilanlar listelendi!");
    }

    @Override
    public Result deactiveJobAdvert(int jobAdvertId) {
        this.jobAdvertsDao.deactiveJobAdvert(jobAdvertId);
        return new SuccessResult("Success: İlan başarıyla inaktif edildi!");
    }

    @Override
    public Result addJobAdvert(JobAdvert jobAdvert) {
        this.jobAdvertsDao.save(jobAdvert);
        return new SuccessResult("Success: İlan sisteme eklendi!");
    }
}
