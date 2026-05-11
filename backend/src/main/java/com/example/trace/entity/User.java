package com.example.trace.entity;

import com.example.trace.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name="users") @Data
public class User {
 @Id private Long id; @Column(unique=true) private String username; private String password;
 @Enumerated(EnumType.STRING) private Role role;
 private Long orgId; private String orgName;
}
