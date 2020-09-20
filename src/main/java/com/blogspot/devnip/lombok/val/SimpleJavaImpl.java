package com.blogspot.devnip.lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * Core Java code to use final local variables.
 */
public class SimpleJavaImpl {

    public Integer add(Integer intOne, Integer intTwo) {
        final Integer result = intOne + intTwo;
        return result;
    }

    public String toList(String str1, String str2) {
        final List<String> listObj = new ArrayList<>();
        listObj.add(str1);
        listObj.add(str2);
        return listObj.toString();
    }
}
