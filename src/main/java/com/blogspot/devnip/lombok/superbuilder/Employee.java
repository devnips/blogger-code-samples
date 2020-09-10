package com.blogspot.devnip.lombok.superbuilder;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

/**
 * Represents an employee in the company.
 */
@Getter
@SuperBuilder
public class Employee {

    /**
     * Id of the employee
     */
    private final String id;

    /**
     * Employees name
     */
    private final String name;

    /**
     * Date when employee joined the company
     */
    private final LocalDate joiningDate;
}
