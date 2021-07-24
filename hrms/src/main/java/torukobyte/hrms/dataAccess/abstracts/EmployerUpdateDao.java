package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.EmployerUpdate;

import javax.transaction.Transactional;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

    EmployerUpdate getEmployerUpdateById(int id);

    @Transactional
    void deleteEmployerUpdateById(int id);
}