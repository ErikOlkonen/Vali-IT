package ee.bcs.valiit.service;

import ee.bcs.valiit.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private BankRepository BankRepository;

    // siia peame Autowirema mingi Repository
    // private UserRepository userRepository
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = BankRepository.findPasswordByUsername(username);
//        Client client = BankRepository.findPasswordByUsername(username);
        return User.withUsername("username")
                .password(password)
                .roles("USER").build();
    }
    // Client client = userRepository.findByUserName(userName);
    // return User.withUsername(userName)
    // .password(client.getPassword())
}
