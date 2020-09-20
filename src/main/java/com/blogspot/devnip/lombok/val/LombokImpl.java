package com.blogspot.devnip.lombok.val;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Using Lombok's val keyword to generate final local variables.
 * See https://projectlombok.org/features/val
 */
public class LombokImpl {

    public Integer add(Integer intOne, Integer intTwo) {
        val result = intOne + intTwo;
        return result;
    }

    public String toList(String str1, String str2) {
        val listObj = new ArrayList<>();
        listObj.add(str1);
        listObj.add(str2);
        return listObj.toString();
    }

    public void example2() {
        val map = new HashMap<String, String>();
        map.put("Name", "James Smith");
        map.put("Age", "28");
        for (val entry : map.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
