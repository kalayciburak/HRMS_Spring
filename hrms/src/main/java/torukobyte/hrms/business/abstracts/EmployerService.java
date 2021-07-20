package torukobyte.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Employer;

import java.io.IOException;
import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getEmployers();

    Result addEmployer(Employer employer);

    Result updateEmployer(Employer employer);

    Result deleteEmployerById(int employerId);

    DataResult<Employer> getEmployerById(int employerId);

    Result uploadPicture(int employerId, MultipartFile file) throws IOException;

    Result changeIsUpdated(boolean update, int employerId);

    DataResult<List<Employer>> getEmployerByUpdatedTrue();
}
