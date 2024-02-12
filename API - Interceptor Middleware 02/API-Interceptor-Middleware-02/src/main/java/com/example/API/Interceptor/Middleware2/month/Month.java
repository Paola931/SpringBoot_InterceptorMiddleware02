package com.example.API.Interceptor.Middleware2.month;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Month {
    @Id
    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

}
