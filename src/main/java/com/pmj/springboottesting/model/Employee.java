package com.pmj.springboottesting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
