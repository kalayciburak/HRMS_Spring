package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.FavoriteService;
import torukobyte.hrms.core.dtoConverter.DtoConverterService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.FavoriteDao;
import torukobyte.hrms.entities.concretes.Favorite;
import torukobyte.hrms.entities.dtos.addDtos.FavoriteAddDto;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {

    private final FavoriteDao favoriteDao;

    private final DtoConverterService dtoConverterService;

    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao, DtoConverterService dtoConverterService) {
        this.favoriteDao = favoriteDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result addFavorite(FavoriteAddDto favorite) {
        this.favoriteDao.save((Favorite) this.dtoConverterService.dtoClassConverter(favorite, Favorite.class));
        return new SuccessResult("Success: Favorilere eklendi!");
    }

    @Override
    public Result deleteFavorite(int id) {
        this.favoriteDao.deleteById(id);
        return new SuccessResult("Success: Favori başarıyla kaldırıldı!");
    }

    @Override
    public DataResult<List<Favorite>> getFavorites() {
        if (this.favoriteDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.favoriteDao.findAll(), "Success: Favoriler başarıyla listelendi!");
        } else {
            return new WarningDataResult<>(this.favoriteDao.findAll(), "Warning: Kayıtlı Favori listesi bulunamadı!");
        }
    }

    @Override
    public DataResult<List<Favorite>> getFavoriteById(int id) {
        if (this.favoriteDao.getFavoriteByJobSeekerId(id).size() > 0) {
            return new SuccessDataResult<>(
                    this.favoriteDao.getFavoriteByJobSeekerId(id),
                    "Success: " + id + " id li iş arayana ait favoriler listelendi!");
        } else {
            return new WarningDataResult<>(
                    this.favoriteDao.getFavoriteByJobSeekerId(id),
                    "Warning: " + id + " id li iş arayana ait favori bulunamadı!");
        }

    }
}
