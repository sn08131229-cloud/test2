package com.example.trace.entity;
import jakarta.persistence.*; import lombok.Data; import java.time.LocalDateTime;
@Entity @Data
public class PurchaseOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long orderId;
 private Long deviceId; private String deviceCode; private Long supplierId; private String supplierName; private Long hospitalId; private String hospitalName;
 private LocalDateTime applyTime; private LocalDateTime approveTime; private LocalDateTime receiveTime; private String status; private String remark;
}
