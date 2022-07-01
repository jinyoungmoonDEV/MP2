package com.example.MP2.service;

import com.example.MP2.entity.User;
import com.example.MP2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(final User user) {
        if(user == null || user.getEmail() == null ) {//값이 없을떄
            throw new RuntimeException("Invalid arguments");
        }
        final String email = user.getEmail();
        if(userRepository.existsByEmail(email)) {//boolean 결과 True일떄
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);//boolean 결과 False일떄 .save로 저장
    }

    public User getByCredentials(final String email, final String password, final PasswordEncoder encoder) {
        final User originalUser = userRepository.findByEmail(email);

        // matches 메서드를 이용해 패스워드가 같은지 확인
        if(originalUser != null && encoder.matches(password, originalUser.getPassword())) {
            return originalUser;
        }
        return null;
    }
}
