package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.*;
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
        if ((long) this.jobAdvertsDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "Success: Tüm iş ilanları listelendi.");
        }
        return new WarningDataResult<>(this.jobAdvertsDao.findAll(), "Warning: Herhangi bir iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdverts() {
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue().size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(),
                    "Success: Aktif tüm iş ilanları listelendi!");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(),
                "Warning: Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getActiveJobAdvertsForEmployer(String companyName) {
        if ((long) this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName).size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(
                    companyName), "Success: Şirket'e ait tüm ilanlar listelendi!");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName),
                "Warning: Şirket'e ait herhangi bir ilan bulunamadı!");

    }

    @Override
    public DataResult<List<JobAdvert>> findAllByIsActiveTrue() {
        Sort sort = Sort.by(Sort.Direction.DESC, "airdate");
        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                    "Success: Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                "Warning: Aktif iş ilanı bulunamadı!");
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
