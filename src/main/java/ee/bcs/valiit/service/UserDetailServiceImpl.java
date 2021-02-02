package ee.bcs.valiit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
// siia peame Autowirema mingi Repository
    // private UserRepository userRepository
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return User.withUsername("test")
                .password(passwordEncoder.encode("test"))
                .roles("USER").build();
    }
    // Client client = userRepository.findByUserName(userName);
    // return User.withUsername(userName)
    // .password(client.getPassword())
}
