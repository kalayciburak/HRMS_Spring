package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobAdvertService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.JobAdvertDao;
import torukobyte.hrms.entities.concretes.JobAdvert;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {
    private final JobAdvertDao jobAdvertsDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertsDao) {
        this.jobAdvertsDao = jobAdvertsDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdverts() {
        if ((long) this.jobAdvertsDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.findAll(), "Success: Tüm iş ilanları listelendi.");
        }
        return new WarningDataResult<>(this.jobAdvertsDao.findAll(), "Herhangi bir iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getSortedJobAdverts() {
        Sort sort = Sort.by(Sort.Direction.DESC, "airdate");
        return new SuccessDataResult<>(
                this.jobAdvertsDao.findAll(sort),
                "Success: iş ilanları listelendi!");
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
                "Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByCompanyName(String companyName) {
        if ((long) this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName).size() > 0) {
            return new SuccessDataResult<>(this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(
                    companyName), "Success: Şirket'e ait tüm ilanlar listelendi!");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndEmployer_CompanyName(companyName),
                "Şirket'e ait herhangi bir ilan bulunamadı!");

    }

    @Override
    public DataResult<List<JobAdvert>> findAllByIsActiveTrue(boolean isDesc) {
        Sort sort;
        if (isDesc) {
            sort = Sort.by(Sort.Direction.DESC, "airdate");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "airdate");
        }

        if ((long) this.jobAdvertsDao.findAllByIsActiveTrue(sort).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                    "Aktif tüm iş ilanları yayınlanma tarihine göre listelendi!");
        }
        return new WarningDataResult<>(
                this.jobAdvertsDao.findAllByIsActiveTrue(sort),
                "Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageDesc(
            int pageNo,
            int pageSize) {

        Sort sort;
        sort = Sort.by(Sort.Direction.DESC, "airdate");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                    "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre azalarak listelendi!");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrueByPageAsc(int pageNo, int pageSize) {

        Sort sort;
        sort = Sort.by(Sort.Direction.ASC, "airdate");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable).size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                    "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre artarak listelendi!");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(pageable),
                "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertByIsActiveTrueAndIsConfirmedTrue() {
        if (this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue().size() > 0) {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(),
                    "Success: Onaylı ve Aktif tüm iş ilanları yayınlanma tarihine göre artarak listelendi!");
        }

        return new WarningDataResult<>(
                this.jobAdvertsDao.getJobAdvertByIsActiveTrueAndIsConfirmedTrue(),
                "Warning: Onaylı ve Aktif iş ilanı bulunamadı!");
    }

    @Override
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId) {
        if (this.jobAdvertsDao.getJobAdvertById(jobAdvertId) == null) {
            return new WarningDataResult<>("Warning: Kayıtlı İş İlanı bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.jobAdvertsDao.getJobAdvertById(jobAdvertId),
                    "Success: İş İlanı listelendi!");
        }
    }

    @Override
    public Result changeIsActive(boolean active, int jobAdvertId) {
        this.jobAdvertsDao.changeIsActive(active, jobAdvertId);
        return new SuccessResult("Success: İlan aktiflik durumu değiştirildi!");
    }

    @Override
    public Result changeIsConfirmed(boolean confirm, int jobAdvertId) {
        this.jobAdvertsDao.changeIsConfirmed(confirm, jobAdvertId);
        return new SuccessResult("Success: İlan onay durumu değiştirildi!");
    }

    @Override
    public Result addJobAdvert(JobAdvert jobAdvert) {
        this.jobAdvertsDao.save(jobAdvert);
        return new SuccessResult("Success: İlan sisteme eklendi!");
    }

    @Override
    public Result deleteJobAdvertById(int jobAdvertId) {
        this.jobAdvertsDao.deleteJobAdvertById(jobAdvertId);
        return new SuccessResult("Success: İş ilanı silindi!");
    }
}
