package com.demo.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DriverClass {

    public static void main(String[] args) {

        //  Equals & Hash Code

        User user1 = new User("John", 25, "London");

        User user2 = new User("John", 25, "London");

        System.out.println("equals : " + user1.equals(user2));
        System.out.println("Objects equals : " + Objects.equals(user1, user2));

        System.out.println("hash code : " + user1.hashCode());

        //  Comparators

        User user3 = new User("Mark", 30, "New York");
        User user4 = new User("Sean", 25, "California");
        User user5 = new User("Henry", 27, "Boston");
        User user6 = new User("Dmitri", 32, "Moscow");
        User user7 = new User(null, 25, "Paris");
        User user8 = new User("John", 26, "DC");

        List<User> users = Arrays.asList(user2, user3, user4, user5, user6, user7, user8);

        System.out.println("Original List : " + users);

        //  Comparator<User> comp = Comparator.comparingInt(User::getAge);
        Comparator<User> comp = Comparator.comparing(User::getName, Comparator.nullsFirst(Comparator.naturalOrder()))
                .reversed()
                .thenComparing(User::getAge);

        users.sort(comp);

        System.out.println("Sorted : " + users);

    }

}
