package com.example.MP2.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_tbl" , uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
public class User {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; // 유저에게 고유하게 부여되는 id.

    @Column(name = "email", length = 11, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "userid", length = 10, nullable = false)
    private String username;
}
