package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.DepartmentService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.core.utilities.results.SuccessResult;
import torukobyte.hrms.core.utilities.results.WarningDataResult;
import torukobyte.hrms.dataAccess.abstracts.DepartmentDao;
import torukobyte.hrms.entities.concretes.Department;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Result addDepartment(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Bölüm başarıyla eklendi!");
    }

    @Override
    public DataResult<List<Department>> getAllDepartment() {
        if (this.departmentDao.findAll().isEmpty()) {
            return new WarningDataResult<>("Kayıtlı bölüm bulunamadı!");
        } else {
            return new DataResult<>(this.departmentDao.findAll(), "Bölümler başarıyla listelendi!");
        }
    }
}
