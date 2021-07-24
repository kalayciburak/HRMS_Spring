package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.EmployerUpdateService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.EmployerUpdateDao;
import torukobyte.hrms.entities.concretes.EmployerUpdate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

    private final EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }

    @Override
    public DataResult<EmployerUpdate> getEmployerUpdateById(int employerId) {
        if (this.employerUpdateDao.getEmployerUpdateById(employerId) == null) {
            return new WarningDataResult<>("Warning: Kayıtlı Şirket bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.employerUpdateDao.getEmployerUpdateById(employerId),
                    "Success: Şirket başarıyla listelendi!");
        }
    }

    @Override
    public Result deleteEmployerUpdateById(int employerId) {
        this.employerUpdateDao.deleteEmployerUpdateById(employerId);
        return new SuccessResult("Success: Şirket silindi!");
    }

    @Override
    public Result addEmployerUpdate(EmployerUpdate employerUpdate) {
        this.employerUpdateDao.save(employerUpdate);
        return new SuccessResult("Success: Şirket eklendi!");
    }
}
