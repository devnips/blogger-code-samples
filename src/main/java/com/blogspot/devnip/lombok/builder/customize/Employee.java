package com.blogspot.devnip.lombok.builder.customize;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDate;

@Getter
@Builder
public class Employee {

    @NonNull
    private final String name;

    /**
     * Let's add following validations:
     * 1. Employee Id must start with `P` or `T`
     * 2. Must be of length 5
     */
    private final String employeeId;

    @NonNull
    private final LocalDate joiningDate;

    // ##########################################
    // Below we add the custom code to validate employeeId
    // ##########################################

    /**
     * Override the builder() method to return our custom builder instead of the Lombok generated builder class.
     *
     * @return
     */
    public static EmployeeBuilder builder() {
        return new CustomBuilder();
    }

    /**
     * Customized builder class, extends the Lombok generated builder class and overrides method implementations.
     */
    private static class CustomBuilder extends EmployeeBuilder {

        /**
         * Adding validations as part of build() method.
         *
         * @return
         */
        public Employee build() {

            if (super.employeeId == null || super.employeeId.trim().length() != 5) {
                throw new RuntimeException("Employee Id must be of 5 characters");
            }

            final char firstCharacter = super.employeeId.toCharArray()[0];
            if (firstCharacter != 'P' && firstCharacter != 'T') {
                throw new RuntimeException("Employee Id must begin with character `P` or `T`");
            }

            return super.build();
        }
    }
}
