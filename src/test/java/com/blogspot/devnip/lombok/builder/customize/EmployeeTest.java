package com.blogspot.devnip.lombok.builder.customize;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EmployeeTest {

    /**
     * Create Employee object with valid data.
     */
    @Test
    public void valid_data() {
        Employee employee = Employee.builder()
                .name("James Wittel")
                .joiningDate(LocalDate.now())
                .employeeId("P1234")
                .build();

        Assertions.assertNotNull(employee);
    }

    /**
     * Creating employee object with null employee Id should generate error.
     */
    @Test
    public void null_employee_id() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> Employee.builder()
                        .name("James Wittel")
                        .joiningDate(LocalDate.now())
                        .employeeId(null)
                        .build());
    }

    /**
     * Creating employee object with invalid length employee Id should generate error.
     */
    @Test
    public void invalid_length_employee_id() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> Employee.builder()
                        .name("James Wittel")
                        .joiningDate(LocalDate.now())
                        .employeeId("P938838838")
                        .build());
    }

    /**
     * Creating employee object with invalid starting character of employee Id, should generate error.
     */
    @Test
    public void invalid_start_character_employee_id() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> Employee.builder()
                        .name("James Wittel")
                        .joiningDate(LocalDate.now())
                        .employeeId("A9388")
                        .build());
    }
}