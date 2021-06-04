package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.ProgrammingLanguageService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import torukobyte.hrms.entities.concretes.ProgrammingLanguage;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private final ProgrammingLanguageDao programmingLanguageDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public Result addProgrammingLanguage(ProgrammingLanguage pl) {
        this.programmingLanguageDao.save(pl);
        return new SuccessResult("Success: Programlama dili başarıyla eklendi!");
    }

    @Override
    public DataResult<List<ProgrammingLanguage>> getAllProgrammingLanguage() {
        if (this.programmingLanguageDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı bir programlama dili yok!");
        }
        return new SuccessDataResult<>(
                this.programmingLanguageDao.findAll(),
                "Success: Programlama dilleri başarıyla listelendi!");
    }
}
