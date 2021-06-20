package torukobyte.hrms.emailValidator;

import org.springframework.stereotype.Service;
import torukobyte.hrms.entities.concretes.User;

@Service
public class EmailValidatorManager {
    public String emailValidator(User user) {
        return "Doğrulama kodu " + user.getEmail() + " adresine gönderildi";
    }
}
