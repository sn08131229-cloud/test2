package com.example.trace.repo;
import com.example.trace.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrganizationRepo extends JpaRepository<Organization, Long> {}
