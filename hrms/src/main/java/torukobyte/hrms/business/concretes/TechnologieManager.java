package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.TechnologieService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.TechnologieDao;
import torukobyte.hrms.entities.concretes.Technology;
import torukobyte.hrms.entities.dtos.addDtos.TechnologyAddDto;

import java.util.List;

@Service
public class TechnologieManager implements TechnologieService {

    private final TechnologieDao technologieDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public TechnologieManager(TechnologieDao technologieDao, DtoConverterService dtoConverterService) {
        this.technologieDao = technologieDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addProgrammingLanguage(TechnologyAddDto pl) {
        this.technologieDao.save((Technology) this.dtoConverterService.dtoClassConverter(pl, Technology.class));
        return new SuccessResult("Success: Programlama dili başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Technology>> getAllProgrammingLanguage() {
        if (this.technologieDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı bir programlama dili yok!");
        }
        return new SuccessDataResult<>(
                this.technologieDao.findAll(),
                "Success: Programlama dilleri başarıyla listelendi!");
    }
}
