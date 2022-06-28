package com.example.MP2.service;

import com.example.MP2.entity.User;
import com.example.MP2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(final User user) {
        if(user == null || user.getPhonenumber() == null ) {
            throw new RuntimeException("Invalid arguments");
        }
        final String phonenumber = user.getPhonenumber();
        if(userRepository.existsByPhonenumber(phonenumber)) {
            log.warn("Email already exists {}", phonenumber);
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    public User getByCredentials(final String phonenumber, final String password, final PasswordEncoder encoder) {
        final User originalUser = userRepository.findByPhonenumber(phonenumber);

        // matches 메서드를 이용해 패스워드가 같은지 확인
        if(originalUser != null && encoder.matches(password, originalUser.getPassword())) {
            return originalUser;
        }
        return null;
    }
}
