package com.blogspot.devnip.stream;

import com.blogspot.devnip.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ListOfObjectToMapOfListTest {

    @Test
    void test() {
        List<Person> personList = Arrays.asList(
                new Person(1L, "Person One", "US"),
                new Person(2L, "Person Two", "US"),
                new Person(3L, "Person One", "CA")
        );

        Map<String, List<Person>> countryMap = ListOfObjectToMapOfList.convert(personList);

        Assertions.assertEquals(2, countryMap.size());
        Assertions.assertEquals(2, countryMap.get("US").size());
        Assertions.assertEquals(1, countryMap.get("CA").size());
    }
}