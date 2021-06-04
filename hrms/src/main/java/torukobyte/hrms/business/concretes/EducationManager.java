package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.EducationService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.EducationDao;
import torukobyte.hrms.entities.concretes.Education;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result addEducation(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Success: Eğitim bilgileri başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Education>> getAllEducations() {
        if (this.educationDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Listelenecek bir eğitim bilgisi bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.educationDao.findAll(),
                    "Success: Tüm eğitim bilgileri başarıyla listelendi!");
        }
    }
}
