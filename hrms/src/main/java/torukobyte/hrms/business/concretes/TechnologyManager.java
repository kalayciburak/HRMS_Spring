package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.TechnologyService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.TechnologyDao;
import torukobyte.hrms.entities.concretes.Technology;
import torukobyte.hrms.entities.dtos.addDtos.TechnologyAddDto;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyDao technologieDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public TechnologyManager(TechnologyDao technologieDao, DtoConverterService dtoConverterService) {
        this.technologieDao = technologieDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addTechnology(TechnologyAddDto pl) {
        this.technologieDao.save((Technology) this.dtoConverterService.dtoClassConverter(pl, Technology.class));
        return new SuccessResult("Success: Programlama dili başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Technology>> getTechnologies() {
        if (this.technologieDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Warning: Kayıtlı bir programlama dili yok!");
        }
        return new SuccessDataResult<>(
                this.technologieDao.findAll(),
                "Success: Programlama dilleri başarıyla listelendi!");
    }

    @Override
    public DataResult<List<Technology>> getTechnologieByCurriculaVitaeId(int id) {
        if (this.technologieDao.getTechnologieByCurriculaVitaeId(id).isEmpty()) {
            return new WarningDataResult<>("Warning: Listelenecek teknoloji bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.technologieDao.getTechnologieByCurriculaVitaeId(id),
                    "Success: Teknolojiler başarıyla listelendi!");
        }
    }
}
