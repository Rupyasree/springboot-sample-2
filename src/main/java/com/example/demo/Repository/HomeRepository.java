package com.example.demo.Repository;

import com.example.demo.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {
    Home findByEmail(String email);
}
