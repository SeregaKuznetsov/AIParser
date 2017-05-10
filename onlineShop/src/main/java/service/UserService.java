package service;

import form.UserRegistrationForm;
import model.User;

import java.util.List;

/**
 * Created by admin on 10.04.2017.
 */
public interface UserService {
    void saveNewUser(UserRegistrationForm form);
    List<User> getAllUsers();
}
