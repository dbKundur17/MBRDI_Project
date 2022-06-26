package mbrdi.cars.loginform.service;


import mbrdi.cars.loginform.model.Usermodel;
import mbrdi.cars.loginform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class Userservice {

    private final UserRepository userRepository;

    public Userservice(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public Usermodel registerUser(String username, String password, String email) {
        if (username != null && password != null) {
            return null;
        } else {
            Usermodel um = new Usermodel();
            um.setUsername(username);
            um.setEmail(email);
            um.setPassword(password);
            userRepository.save(um);
            return userRepository.save(um);

        }

    }

    public Usermodel authenticate(String username, String password){
        return userRepository.findByLoginAndPassword(username,password).orElse(null);
    }
}
