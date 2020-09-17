package com.blogspot.devnip.lombok.settergetter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class SimpleObject {

    private String name;
    private LocalDate dateOfBirth;
}
