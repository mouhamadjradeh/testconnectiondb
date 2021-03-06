package com.mouhamadjradeh.testconnectiondb.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

//This class will implement an interface specific for security
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND_MSG="USER WITH EMAIL %s NOT found ";
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()->new
                UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }
}
