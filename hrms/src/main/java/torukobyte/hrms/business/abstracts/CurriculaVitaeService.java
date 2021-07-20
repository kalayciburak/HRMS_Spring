package torukobyte.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.CurriculaVitae;
import torukobyte.hrms.entities.dtos.addDtos.CurriculaVitaeAddDto;
import torukobyte.hrms.entities.dtos.updateDtos.CurriculaVitaeUpdateDto;

import java.io.IOException;

public interface CurriculaVitaeService {

    Result addCv(CurriculaVitaeAddDto curriculaVitae);

    Result updateCv(CurriculaVitaeUpdateDto curriculaVitae);


//    DataResult<List<JobseekerWithCurriculaVitaeDto>> getJobSeekerWithCurriculaVitae(int id);

    DataResult<CurriculaVitae> findByJobSeekerId(int jobseekerId);

    //!addCvWithPicture yazılacak..
    Result uploadPicture(int cvId, MultipartFile file) throws IOException;
}
