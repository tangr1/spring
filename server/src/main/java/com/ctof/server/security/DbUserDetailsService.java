package com.ctof.server.security;

import com.ctof.server.model.UserModel;
import com.ctof.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DbUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByEmail(email);

        if (userModel == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            return new SecureUser(
                    userModel.getId(),
                    userModel.getEmail(),
                    userModel.getPassword(),
                    AuthorityUtils.commaSeparatedStringToAuthorityList(userModel.getRole().toString())
            );
        }
    }

}
