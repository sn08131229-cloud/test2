package com.example.trace.repo;
import com.example.trace.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface DeviceRepo extends JpaRepository<Device, Long> { Optional<Device> findByDeviceCode(String deviceCode); }
