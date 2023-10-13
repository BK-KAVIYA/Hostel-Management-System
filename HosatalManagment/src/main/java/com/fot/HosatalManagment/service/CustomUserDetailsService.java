package com.fot.HosatalManagment.service;


import com.fot.HosatalManagment.entity.User;
import com.fot.HosatalManagment.repository.UserRepository;
import com.fot.HosatalManagment.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user details from your database
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new CustomUserDetails(user);
    }

    public User save(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String encyptedpwd=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encyptedpwd);

        return userRepository.save(user);
    }

}

