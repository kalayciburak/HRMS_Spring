package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
