package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import torukobyte.hrms.entities.concretes.JobAdvert;

import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertsDao extends JpaRepository<JobAdvert, Integer> {
    List<JobAdvert> findAllByIsActiveTrue();

    List<JobAdvert> getJobAdvertByIsActiveTrueAndEmployer_CompanyName(String companyName);

    @Transactional
    @Modifying
    @Query("Update JobAdvert set isActive = false where id =:jobAdvertId")
    void deactiveJobAdvert(int jobAdvertId);
}
