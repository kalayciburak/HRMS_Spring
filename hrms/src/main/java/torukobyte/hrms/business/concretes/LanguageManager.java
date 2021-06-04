package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.LanguageService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.SuccessDataResult;
import torukobyte.hrms.core.utilities.results.WarningDataResult;
import torukobyte.hrms.dataAccess.abstracts.LanguageDao;
import torukobyte.hrms.entities.concretes.Language;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> addLanguages(List<Language> languages) {
        return new SuccessDataResult<>(
                this.languageDao.saveAll(languages),
                "Success: Yabancı dil ekleme işlemi başarılı!");
    }

    @Override
    public DataResult<List<Language>> getLanguages() {
        if (this.languageDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı yabancı dil bulunamadı!");
        }
        return new SuccessDataResult<>(this.languageDao.findAll(), "Success: Yabancı diller başarıyla listelendi!");

    }
}
