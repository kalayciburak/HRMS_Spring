package torukobyte.hrms.api.controllers;

import org.springframework.web.bind.annotation.*;
import torukobyte.hrms.business.abstracts.FavoriteService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.Result;
import torukobyte.hrms.entities.concretes.Favorite;
import torukobyte.hrms.entities.dtos.addDtos.FavoriteAddDto;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class FavoritesContoller {

    private final FavoriteService favoriteService;

    public FavoritesContoller(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/getFavorites")
    public DataResult<List<Favorite>> getFavorites() {
        return this.favoriteService.getFavorites();
    }

    @GetMapping("/getFavoritesByJobSeekerId")
    public DataResult<List<Favorite>> getFavoritesByJobSeekerId(@RequestParam int jobSeekerId) {
        return this.favoriteService.getFavoriteById(jobSeekerId);
    }

    @PostMapping("/addFavorite")
    public Result addFavorite(@RequestBody FavoriteAddDto favorite) {
        return this.favoriteService.addFavorite(favorite);
    }

    @DeleteMapping("/deleteFavorite")
    public Result deleteFavorite(@RequestParam int id) {
        return this.favoriteService.deleteFavorite(id);
    }

    @DeleteMapping("/deleteFavoriteByJobSeekerIdAndJobAdvertId")
    public Result deleteFavoriteByJobSeekerIdAndJobAdvertId(@RequestParam int jobSeekerId, int jobAdvertId) {
        return this.favoriteService.deleteFavoriteByJobSeekerIdAndJobAdvertId(jobSeekerId, jobAdvertId);
    }


}
