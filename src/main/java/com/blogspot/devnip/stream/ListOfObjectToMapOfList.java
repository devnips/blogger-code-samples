package com.blogspot.devnip.stream;

import com.blogspot.devnip.data.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Group a list of objects by a field
 */
public class ListOfObjectToMapOfList {

    public static Map<String, List<Person>> convert(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getCountry));
    }
}
