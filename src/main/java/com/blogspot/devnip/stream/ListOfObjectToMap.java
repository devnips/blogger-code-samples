package com.blogspot.devnip.stream;

import com.blogspot.devnip.data.Person;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Convert a list of object to map
 */
public class ListOfObjectToMap {

    public static Map<Long, Person> convert(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.toMap(Person::getId, Function.identity()));
    }
}
