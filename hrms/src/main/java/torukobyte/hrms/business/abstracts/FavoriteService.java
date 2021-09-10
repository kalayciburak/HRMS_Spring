package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Favorite;
import torukobyte.hrms.entities.dtos.addDtos.FavoriteAddDto;

import java.util.List;

public interface FavoriteService {
    Result addFavorite(Favorite favorite);

    Result deleteFavorite(int id);

    Result deleteFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);

    DataResult<List<Favorite>> getFavorites();

    DataResult<List<Favorite>> getFavoriteById(int id);
}
