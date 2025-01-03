package com.pharmacy.pharmacy_billing.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacy.pharmacy_billing.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
