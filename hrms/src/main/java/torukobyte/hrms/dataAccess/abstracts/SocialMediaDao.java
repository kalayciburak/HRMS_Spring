package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.SocialMedia;

import java.util.List;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
    List<SocialMedia> getSocialMediaByCurriculaVitaeId(int id);
}
