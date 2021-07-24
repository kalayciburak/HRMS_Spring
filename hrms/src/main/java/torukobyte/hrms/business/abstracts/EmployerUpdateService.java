package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {
    DataResult<EmployerUpdate> getEmployerUpdateById(int employerId);

    Result deleteEmployerUpdateById(int employerId);

    Result addEmployerUpdate(EmployerUpdate employerUpdate);
}
