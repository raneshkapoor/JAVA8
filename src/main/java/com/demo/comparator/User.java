package com.demo.comparator;

import java.util.Objects;

public final class User {

    private String name;

    private int age;

    private String contact;

    public User(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof User)) {
            return false;
        } else {
            final User other = (User) o;
            return Objects.equals(this.name, other.name)
                    && this.age == other.age
                    && Objects.equals(this.contact, other.contact);
        }
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.name == null ? 43 : this.name.hashCode());
        result = result * PRIME + this.age;
        result = result * PRIME + (this.contact == null ? 43 : this.contact.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User : Name - " + this.name + ". Age - " + this.age + ". Contact - " + this.contact;
    }
}
