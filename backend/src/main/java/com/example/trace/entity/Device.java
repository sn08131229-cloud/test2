package com.example.trace.entity;
import com.example.trace.enums.DeviceStatus;
import jakarta.persistence.*; import lombok.Data; import java.time.LocalDate; import java.time.LocalDateTime;
@Entity @Data
public class Device {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long deviceId;
 @Column(unique=true) private String deviceCode;
 private String deviceName; private String deviceType; private String model; private String manufacturer;
 private Long supplierId; private String supplierName; private String batchNo; private String serialNo;
 private LocalDate productionDate; private LocalDate validUntil;
 private Long currentOwnerOrgId; private String currentOwnerOrgName; private Long currentHolderOrgId; private String currentHolderOrgName;
 @Enumerated(EnumType.STRING) private DeviceStatus status; private String maintenanceStatus;
 private LocalDateTime createdAt; private LocalDateTime updatedAt;
}
