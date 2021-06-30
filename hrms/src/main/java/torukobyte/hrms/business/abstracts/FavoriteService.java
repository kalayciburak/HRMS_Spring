package torukobyte.hrms.business.abstracts;

import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Favorite;
import torukobyte.hrms.entities.dtos.addDtos.FavoriteAddDto;

import java.util.List;

public interface FavoriteService {
    Result addFavorite(FavoriteAddDto favorite);

    Result deleteFavorite(int id);

    DataResult<List<Favorite>> getFavorites();

    DataResult<List<Favorite>> getFavoriteById(int id);
}
