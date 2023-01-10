package com.cpoletti.apispring.repository;

import com.cpoletti.apispring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
