package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.SchoolService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.SchoolDao;
import torukobyte.hrms.entities.concretes.School;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result addSchool(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Okul başarıyla eklendi!");
    }

    @Override
    public DataResult<List<School>> getAllSchool() {
        if (this.schoolDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Kayıtlı okul bulunamadı!");
        } else {
            return new SuccessDataResult<>(this.schoolDao.findAll(), "Bütün okullar başarıyla listelendi!");
        }
    }
}
