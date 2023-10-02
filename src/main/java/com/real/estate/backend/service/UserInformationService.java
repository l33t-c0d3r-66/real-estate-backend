package com.real.estate.backend.service;

import com.real.estate.backend.model.UserInformation;
import com.real.estate.backend.repository.UserInformationRepository;
import com.real.estate.backend.security.model.UserInformationDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInformationService implements UserDetailsService {

    @Autowired
    private UserInformationRepository userInformationRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInformation> userInformationOptional = userInformationRepository.findByName(username);
        return userInformationOptional.map(UserInformationDetail::new).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist with user id"+username));
    }

    public String addUser(UserInformation userInformation) {
        userInformation.setPassword(encoder.encode(userInformation.getPassword()));
        userInformationRepository.save(userInformation);
        return "User Added Successfully";
    }
}
