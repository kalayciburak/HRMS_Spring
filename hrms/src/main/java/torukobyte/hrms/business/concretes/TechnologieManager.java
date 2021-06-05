package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.TechnologieService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.TechnologieDao;
import torukobyte.hrms.entities.concretes.Technologie;

import java.util.List;

@Service
public class TechnologieManager implements TechnologieService {

    private final TechnologieDao technologieDao;

    @Autowired
    public TechnologieManager(TechnologieDao technologieDao) {
        this.technologieDao = technologieDao;
    }

    @Override
    public Result addProgrammingLanguage(Technologie pl) {
        this.technologieDao.save(pl);
        return new SuccessResult("Success: Programlama dili başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Technologie>> getAllProgrammingLanguage() {
        if (this.technologieDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı bir programlama dili yok!");
        }
        return new SuccessDataResult<>(
                this.technologieDao.findAll(),
                "Success: Programlama dilleri başarıyla listelendi!");
    }
}
