package com.example.MP2.repository;

import com.example.MP2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByPhoneNumber(String PhoneNumber);
    Boolean existsByPhoneNumber(String PhoneNumber);
    User findByPhoneNumberAndPassWord(String PhoneNumber, String PassWord);
}
