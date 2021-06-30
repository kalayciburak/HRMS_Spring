package torukobyte.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.CurriculaVitae;
import torukobyte.hrms.entities.dtos.addDtos.CurriculaVitaeAddDto;

import java.io.IOException;

public interface CurriculaVitaeService {

    Result addCv(CurriculaVitaeAddDto curriculaVitae);

    Result updateCv(CurriculaVitae curriculaVitae);


//    DataResult<List<JobseekerWithCurriculaVitaeDto>> getJobSeekerWithCurriculaVitae(int id);

    DataResult<CurriculaVitae> findByJobSeekerId(int jobseekerId);

    //!addCvWithPicture yazılacak..
    Result uploadPicture(int cvId, MultipartFile file) throws IOException;
}
