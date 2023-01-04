package com.cpoletti.apispring.repository;

import com.cpoletti.apispring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
