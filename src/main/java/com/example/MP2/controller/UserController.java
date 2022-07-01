package com.example.MP2.controller;

import com.example.MP2.dto.ResponseDTO;
import com.example.MP2.dto.UserDTO;
import com.example.MP2.entity.User;
import com.example.MP2.security.TokenProvider;
import com.example.MP2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//security passwordencoding

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){//htttp요청 본문(body)이 그대로 전달 <-> UserDTO
        //ResponseEntity는 HttpEntity클래스를 상속 받은 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
        try {
            // 리퀘스트를 이용해 저장할 유저 만들기
            User user = User.builder()//빌더 패턴으로 생성자 생성
                    .email(userDTO.getEmail())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .username(userDTO.getUsername())
                    .build();
            // 서비스를 이용해 리파지토리에 유저 저장
            User registeredUser = userService.create(user);//UserService의 create 메소드 변수
            UserDTO responseUserDTO = UserDTO.builder()//빌더 패턴
                    .email(registeredUser.getEmail())//변수의 값 불러와 저장
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .build();
            // 유저 정보는 항상 하나이므로 그냥 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 리턴.
            return ResponseEntity.ok(responseUserDTO);//ok
        } catch (Exception e) {
            // 예외가 나는 경우 bad 리스폰스 리턴.
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

    @PostMapping ("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        User user = userService.getByCredentials(//정보가 같은지 확인하는 메서드
                userDTO.getEmail(),
                userDTO.getPassword(),
                passwordEncoder);

        if (user != null) {//null이 아니면
            // 토큰 생성
            final String token = tokenProvider.create(user);//토큰 생성
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);//ok UserDTO.builder return
        } else {//null이면
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed.")
                    .build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
}
