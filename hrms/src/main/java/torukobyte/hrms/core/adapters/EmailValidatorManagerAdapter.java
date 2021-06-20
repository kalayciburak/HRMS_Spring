package torukobyte.hrms.core.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torukobyte.hrms.core.services.EmailCheckService;
import torukobyte.hrms.emailValidator.EmailValidatorManager;
import torukobyte.hrms.entities.concretes.User;

@Service
public class EmailValidatorManagerAdapter implements EmailCheckService {

    private final EmailValidatorManager emailValidatorManager;

    @Autowired
    public EmailValidatorManagerAdapter(EmailValidatorManager emailValidatorManager) {
        this.emailValidatorManager = emailValidatorManager;
    }

    @Override
    public String emailValidator(User user) {
        return this.emailValidatorManager.emailValidator(user);
    }
}
