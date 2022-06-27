package com.example.MP2.repository;

import com.example.MiniProject2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByPhoneNumber(String PhoneNumber);
    Boolean existsByPhoneNumber(String PhoneNumber);
    //UserEntity findByPhoneNumberAndPassWord(String PhoneNumber, String PassWord);
}
