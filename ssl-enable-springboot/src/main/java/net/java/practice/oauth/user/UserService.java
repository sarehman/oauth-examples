package net.java.practice.oauth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
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

    public void updateAuthenticationType(String username, String oauth2ClientName) {
        Provider authType = Provider.valueOf(oauth2ClientName.toUpperCase());
        userRepository.updateAuthenticationType(username, authType);
        System.out.println("Updated user's authentication type to " + authType);
    }
}
