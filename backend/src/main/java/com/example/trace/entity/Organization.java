package com.example.trace.entity;

import com.example.trace.enums.OrgType;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class Organization {
 @Id private Long id;
 private String orgName;
 @Enumerated(EnumType.STRING) private OrgType orgType;
 private String contactName; private String contactPhone; private String address; private String licenseNo;
}
