package com.example.API.Interceptor.Middleware2.month;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<Month,Integer> {
}
