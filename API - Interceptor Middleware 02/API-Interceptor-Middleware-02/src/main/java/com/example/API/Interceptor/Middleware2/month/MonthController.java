package com.example.API.Interceptor.Middleware2.month;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/months")
public class MonthController {
    @Autowired
    private MonthService monthService;
    @GetMapping("/get")
    public Month getMonth( HttpServletRequest request){
       return (Month) request.getAttribute("monthNumber");
    }
}
