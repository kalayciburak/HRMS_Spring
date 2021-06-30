package torukobyte.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import torukobyte.hrms.entities.concretes.Favorite;

import java.util.List;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {
    List<Favorite> getFavoriteByJobSeekerId(int id);
}
