package service.impl;

import form.UserRegistrationForm;
import form.UserRegistrationFormToUserTransformer;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;

import java.util.List;

/**
 * Created by admin on 15.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveNewUser(UserRegistrationForm form) {
        User user = UserRegistrationFormToUserTransformer.transform(form);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
