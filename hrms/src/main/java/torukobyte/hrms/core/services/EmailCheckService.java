package torukobyte.hrms.core.services;

import torukobyte.hrms.entities.concretes.User;

public interface EmailCheckService {
    String emailValidator(User user);
}