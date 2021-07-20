package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import torukobyte.hrms.entities.concretes.Employer;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getEmployerById(int id);

    List<Employer> getEmployerByIsUpdatedTrue();

    @Transactional
    void deleteEmployerById(int id);

    @Transactional
    @Modifying
    @Query("Update Employer set isUpdated =:update where id =:employerId")
    void changeIsUpdated(boolean update, int employerId);
}
