package com.example.trace.entity;
import jakarta.persistence.*; import lombok.Data; import java.time.LocalDate; import java.time.LocalDateTime;
@Entity @Data
public class BorrowOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long borrowId;
 private Long deviceId; private String deviceCode; private Long lenderHospitalId; private String lenderHospitalName; private Long borrowerHospitalId; private String borrowerHospitalName;
 private String reason; private LocalDate expectedReturnDate; private LocalDateTime applyTime; private LocalDateTime approveTime; private LocalDateTime lendTime; private LocalDateTime receiveTime; private LocalDateTime returnApplyTime; private LocalDateTime returnConfirmTime;
 private String status; private String remark;
}
