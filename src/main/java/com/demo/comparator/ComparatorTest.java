package com.demo.comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    private List<User> originalList;

    @Before
    public void init() {
        originalList = new ArrayList<User>();
        originalList.add(new User("John", 25, "London"));
        originalList.add(new User("Sean", 27, "New York"));
        originalList.add(new User("Mark", 25, "Boston"));
        originalList.add(new User("Henry", 30, "California"));
        originalList.add(new User("Dmitri", 28, "Moscow"));
    }

    @Test
    public void testSortByName() {

        List<User> users = new ArrayList<User>(originalList);

        Comparator<User> comp = Comparator.comparing(User::getName);
        users.sort(comp);

        Assert.assertEquals("Dmitri", users.get(0).getName());
        Assert.assertEquals("Sean", users.get(users.size() - 1).getName());
    }

    @Test
    public void testSortByNameReversed() {

        List<User> users = new ArrayList<User>(originalList);

        Comparator<User> comp = Comparator.comparing(User::getName).reversed();
        users.sort(comp);

        Assert.assertEquals("Sean", users.get(0).getName());
        Assert.assertEquals("Dmitri", users.get(users.size() - 1).getName());
    }

    @Test
    public void testSortByAge() {

        List<User> users = new ArrayList<User>(originalList);

        Comparator<User> comp = Comparator.comparingInt(User::getAge);
        users.sort(comp);

        Assert.assertEquals(25, users.get(0).getAge());
        Assert.assertEquals(30, users.get(users.size() - 1).getAge());
    }

    @Test
    public void testSortByAgeReversed() {

        List<User> users = new ArrayList<User>(originalList);

        Comparator<User> comp = Comparator.comparingInt(User::getAge).reversed();
        users.sort(comp);

        Assert.assertEquals(30, users.get(0).getAge());
        Assert.assertEquals(25, users.get(users.size() - 1).getAge());
    }

    @Test
    public void testSortByAgeThenName() {

        List<User> users = new ArrayList<User>(originalList);

        Comparator<User> comp = Comparator.comparingInt(User::getAge).thenComparing(User::getName);
        users.sort(comp);

        Assert.assertEquals("John", users.get(0).getName());
    }

    @Test
    public void testSortByAgeThenNameReversed() {

        List<User> users = new ArrayList<User>(originalList);

        Comparator<User> comp = Comparator.comparingInt(User::getAge).thenComparing(User::getName, Comparator.reverseOrder());
        users.sort(comp);

        Assert.assertEquals("Mark", users.get(0).getName());
    }

}
