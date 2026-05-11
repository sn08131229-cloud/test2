package com.example.trace.repo;
import com.example.trace.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Long> {}
