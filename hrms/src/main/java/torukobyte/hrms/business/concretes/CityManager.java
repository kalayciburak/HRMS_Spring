package torukobyte.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.CityService;
import torukobyte.hrms.core.utilities.results.DataResult;
import torukobyte.hrms.core.utilities.results.SuccessDataResult;
import torukobyte.hrms.core.utilities.results.WarningDataResult;
import torukobyte.hrms.dataAccess.abstracts.CityDao;
import torukobyte.hrms.entities.concretes.City;

import java.util.List;

@Service
public class CityManager implements CityService {

    private final CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getCities() {
        if ((long) this.cityDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.cityDao.findAll(), "Success: Şehirler başarıyla listelendi!");
        }
        return new WarningDataResult<>(this.cityDao.findAll(), "Warning: Herhangi bir şehir bulunamadı!");
    }
}
