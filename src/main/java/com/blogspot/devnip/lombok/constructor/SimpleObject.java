package com.blogspot.devnip.lombok.constructor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class SimpleObject {

    private String name;

    private LocalDate dateOfBirth;

    public SimpleObject(String name) {
        this.name = name;
    }
}
