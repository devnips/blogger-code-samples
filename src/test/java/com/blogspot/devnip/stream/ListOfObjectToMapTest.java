package com.blogspot.devnip.stream;

import com.blogspot.devnip.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ListOfObjectToMapTest {

    @Test
    void test() {
        List<Person> personList = Arrays.asList(
                new Person(1L, "James Smith"),
                new Person(2L, "Michael Jane"));

        Map<Long, Person> personMap = ListOfObjectToMap.convert(personList);

        Assertions.assertEquals(2, personMap.size());
    }
}