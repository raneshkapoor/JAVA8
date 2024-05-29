package com.demo.optional;

import java.util.Optional;

public class OptionalDriver {

    public static void main(String[] args) {

        String java = "java";

        //Optional<String> myString = Optional.empty();
        Optional<String> myString = Optional.of("java");

        System.out.println("is present : " + myString.isPresent());

        System.out.println("if present");

        myString.ifPresent(System.out::println);

        Optional.ofNullable(java).map(String::length).ifPresent(i -> System.out.println("String length : " + i));

    }

}
