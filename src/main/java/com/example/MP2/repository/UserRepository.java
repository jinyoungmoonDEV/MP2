package com.example.MP2.repository;

import com.example.MP2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByphoneNumber(String phoneNumber);
    Boolean existsByphoneNumber(String phoneNumber);
    User findByPhoneNumberAndPassWord(String phoneNumber, String passWord);
}
