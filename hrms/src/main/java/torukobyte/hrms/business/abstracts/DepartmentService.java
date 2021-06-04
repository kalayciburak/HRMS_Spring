package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {
    Result addDepartment(Department department);

    DataResult<List<Department>> getAllDepartment();
}
