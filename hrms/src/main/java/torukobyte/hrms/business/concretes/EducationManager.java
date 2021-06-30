package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.EducationService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.EducationDao;
import torukobyte.hrms.entities.concretes.Education;
import torukobyte.hrms.entities.dtos.addDtos.EducationAddDto;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addEducation(EducationAddDto education) {
        this.educationDao.save((Education) this.dtoConverterService.dtoClassConverter(education, Education.class));
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

    @Override
    public DataResult<List<Education>> getEducationsByCvId(int id) {
        Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
        if (this.educationDao.getEducationEndDateByCurriculaVitaeId(id, sort).isEmpty()) {
            return new WarningDataResult<>("Warning: Listelenecek eğitim bilgisi bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.educationDao.getEducationEndDateByCurriculaVitaeId(id, sort),
                    "Success: Eğitim geçmişi başarıyla sıralanıp listelendi!");
        }
    }
}
