package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.SystemPersonel;

import javax.transaction.Transactional;

public interface SystemPeronelDao extends JpaRepository<SystemPersonel, Integer> {
    SystemPersonel getSystemPersonelById(int id);

    @Transactional
    void deleteSystemPersonelById(int id);
}
