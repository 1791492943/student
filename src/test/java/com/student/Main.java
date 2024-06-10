package com.student;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<myClass>> map = new HashMap<>();

        List<myClass> list = List.of(new myClass(1, "A"), new myClass(2, "B"),new myClass(1, "C"));

//        list.forEach(c -> map.merge(c.getId(), new ArrayList<>(List.of(c)), (oldValue, newValue) -> {
//            oldValue.addAll(newValue);
//            return oldValue;
//        }));

        list.forEach(c -> map.computeIfAbsent(c.getId(), k -> {
            System.out.println(k);
            return new ArrayList<>();
        }).add(c));

        map.entrySet().forEach(System.out::println);

    }

    @Data
    @AllArgsConstructor
    static class myClass {
        private int id;
        private String name;
    }
}
