package com.example.trace.entity;
import jakarta.persistence.*; import lombok.Data; import java.time.LocalDateTime;
@Entity @Data
public class FlowRecord {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long flowId;
 private Long deviceId; private String deviceCode; private String eventType; private Long fromOrgId; private String fromOrgName; private Long toOrgId; private String toOrgName;
 private String operator; private LocalDateTime operateTime; private String businessId; private String businessType; @Column(length=500) private String remark;
 private String dataHash; private String txHash; private Long blockNumber; private String chainStatus; private String verifyStatus;
}
