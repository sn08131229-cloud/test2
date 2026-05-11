package com.example.trace.repo;
import com.example.trace.entity.BorrowOrder;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BorrowOrderRepo extends JpaRepository<BorrowOrder, Long> {}
