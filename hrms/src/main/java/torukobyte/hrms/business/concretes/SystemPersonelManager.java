package torukobyte.hrms.business.concretes;

import org.springframework.stereotype.Service;
import torukobyte.hrms.business.abstracts.SystemPersonelService;
import torukobyte.hrms.core.utilities.results.*;
import torukobyte.hrms.dataAccess.abstracts.SystemPeronelDao;
import torukobyte.hrms.entities.concretes.SystemPersonel;

import java.util.List;

@Service
public class SystemPersonelManager implements SystemPersonelService {

    SystemPeronelDao systemPeronelDao;

    public SystemPersonelManager(SystemPeronelDao systemPeronelDao) {
        this.systemPeronelDao = systemPeronelDao;
    }

    @Override
    public DataResult<List<SystemPersonel>> getSystemPersonels() {
        if ((long) this.systemPeronelDao.findAll().size() > 0) {
            return new SuccessDataResult<>(this.systemPeronelDao.findAll(), "Success: Personeller listelendi!");
        }

        return new WarningDataResult<>(this.systemPeronelDao.findAll(), "Herhangi bir personel bulunamadı!");
    }

    @Override
    public Result addSystemPersonel(SystemPersonel systemPersonel) {
        try {
            this.systemPeronelDao.save(systemPersonel);
            return new SuccessResult("Success: Personel başarıyla eklendi!");
        } catch (Exception e) {
            if (e.getMessage()
                 .contains("[uc_users_email]")) {
                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
            } else {
                return new ErrorResult(
                        "Error: Kullanıcı adı sistem de kayıtlı, lütfen başka bir kullanıcı adı giriniz!");
            }
        }
    }

    @Override
    public Result updateSystemPersonel(SystemPersonel systemPersonel) {
        try {
            this.systemPeronelDao.save(systemPersonel);
            return new SuccessResult("Success: Personel başarıyla güncellendi!");
        } catch (Exception e) {
            if (e.getMessage()
                 .contains("[uc_users_email]")) {
                return new ErrorResult("Error: Eposta sistemde mevcut, lütfen başka bir eposta adresi giriniz!");
            } else {
                return new ErrorResult(
                        "Error: Kullanıcı adı sistem de kayıtlı, lütfen başka bir kullanıcı adı giriniz!");
            }
        }
    }

    @Override
    public DataResult<SystemPersonel> getSystemPersonelById(int systemPersonelId) {
        if (this.systemPeronelDao.getSystemPersonelById(systemPersonelId) == null) {
            return new WarningDataResult<>("Warning: Kayıtlı Personel bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.systemPeronelDao.getSystemPersonelById(systemPersonelId),
                    "Success: Personel listelendi!");
        }
    }

    @Override
    public Result deleteSystemPersonelById(int systemPersonelId) {
        this.systemPeronelDao.deleteSystemPersonelById(systemPersonelId);
        return new SuccessResult("Success: Personel silindi!");
    }
}
