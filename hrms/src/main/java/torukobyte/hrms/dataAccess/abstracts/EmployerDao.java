package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Employer;

import javax.transaction.Transactional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getEmployerById(int id);

    @Transactional
    void deleteEmployerById(int id);
}
