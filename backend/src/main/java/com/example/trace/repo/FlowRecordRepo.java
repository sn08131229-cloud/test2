package com.example.trace.repo;
import com.example.trace.entity.FlowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface FlowRecordRepo extends JpaRepository<FlowRecord, Long> {
List<FlowRecord> findByDeviceCodeOrderByOperateTimeAsc(String deviceCode);
Optional<FlowRecord> findByTxHash(String txHash);
}
