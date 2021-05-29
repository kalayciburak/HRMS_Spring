package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.JobSeekerService;
import torukobyte.hrms.core.services.MernisCheckService;
import torukobyte.hrms.core.utilities.EmailValidator;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.JobSeekerDao;
import torukobyte.hrms.entities.concretes.JobSeeker;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private final JobSeekerDao jobSeekerDao;
    private final MernisCheckService mernisCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService = mernisCheckService;
    }

    @Override
    public DataResult<List<JobSeeker>> getJobSeekers() {
        if ((long) this.jobSeekerDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Success: İş Arayanlar listelendi!");
        }

        return new WarningDataResult<>(this.jobSeekerDao.findAll(), "Warning: Herhangi bir iş arayan bulunamadı!");
    }

    @Override
    public Result addJobSeeker(JobSeeker jobSeeker) {
        try {
            if (!EmailValidator.emailFormatController(jobSeeker.getEmail())) {
                return new ErrorResult("Error: Mail formata uygun değil!");
            } else if (!mernisCheckService.isMernis(jobSeeker)) {
                return new ErrorResult("Error: Gerçek bir kişi değil!");
            } else {
                this.jobSeekerDao.save(jobSeeker);
                return new SuccessResult(
                        "Success: İş arayan kullanıcı sisteme eklendi, Doğrulama kodu email adresinize gönderildi!");
            }
        } catch (Exception e) {
            if (e.getMessage()
                 .contains("[uc_users_email]")) {
                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
            } else {
                return new ErrorResult(
                        "Error: Kimlik numarası sistem de kayıtlı, lütfen başka bir kimlik numarası giriniz!");
            }
        }
    }
}
