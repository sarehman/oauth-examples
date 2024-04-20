package net.java.practice.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void processOAuthPostLogin(String username){

        User user = userRepository.getUserByUsername(username);
        if(null == user){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setProvider(Provider.GOOGLE);
            newUser.setEnabled(true);

            userRepository.save(newUser);
            System.out.println("created new user: "+username);
        }
    }
}
