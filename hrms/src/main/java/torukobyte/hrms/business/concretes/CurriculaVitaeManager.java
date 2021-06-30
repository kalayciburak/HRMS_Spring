package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import torukobyte.hrms.business.abstracts.CurriculaVitaeService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.services.CloudinaryService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.CurriculaVitaeDao;
import torukobyte.hrms.entities.concretes.CurriculaVitae;
import torukobyte.hrms.entities.dtos.addDtos.CurriculaVitaeAddDto;

import java.io.IOException;

@Service
public class CurriculaVitaeManager implements CurriculaVitaeService {

    private final CurriculaVitaeDao curriculaVitaeDao;

    private final CloudinaryService cloudinaryService;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public CurriculaVitaeManager(
            CurriculaVitaeDao curriculaVitaeDao,
            CloudinaryService cloudinaryService,
            DtoConverterService dtoConverterService) {
        this.curriculaVitaeDao = curriculaVitaeDao;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;

    }

    @Override
    public Result addCv(CurriculaVitaeAddDto curriculaVitae) {
        this.curriculaVitaeDao.save((CurriculaVitae) this.dtoConverterService.dtoClassConverter(
                curriculaVitae,
                CurriculaVitae.class));
        return new SuccessResult("Success: Cv başarıyla eklendi!");
    }

    @Override
    public Result updateCv(CurriculaVitae curriculaVitae) {
        this.curriculaVitaeDao.save(curriculaVitae);
        return new SuccessResult("Success: Cv başarıyla güncellendi!");
    }

//    @Override
//    public DataResult<List<JobseekerWithCurriculaVitaeDto>> getJobSeekerWithCurriculaVitae(int id) {
//        if (this.curriculaVitaeDao.getJobSeekerWithCurriculaVitae(id).isEmpty()) {
//            return new WarningDataResult<>("Kayıtlı Cv bulunamadı!");
//        } else {
//            return new SuccessDataResult<>(
//                    this.curriculaVitaeDao.getJobSeekerWithCurriculaVitae(id),
//                    "Cv'ler başarıyla listelendi!");
//
//        }
//    }

    @Override
    public DataResult<CurriculaVitae> findByJobSeekerId(int jobseekerId) {
        if (this.curriculaVitaeDao.findByJobSeekerId(jobseekerId) == null) {
            return new WarningDataResult<>("Warning: Kayıtlı Cv bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.curriculaVitaeDao.findByJobSeekerId(jobseekerId),
                    "Success: Cv'ler başarıyla listelendi!");
        }
    }

    @Override
    public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.addPicture(file);
        var url = result.getData().get("url");

        CurriculaVitae ref = this.curriculaVitaeDao.getOne(cvId);
        ref.setPictureUrl(url.toString());
        this.curriculaVitaeDao.save(ref);

        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }
}