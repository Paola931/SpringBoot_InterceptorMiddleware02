package com.example.API.Interceptor.Middleware2.month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonthService {
    @Autowired
    private MonthRepository monthRepository;
    public Optional<Month> findById(int monthNumber){
        return monthRepository.findById(monthNumber);
    }

}
