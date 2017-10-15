package com.book.library.domain;

public class Edition {
    public String name;

    public Person creator;

    public Edition() {

    }

    public Edition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "name='" + name + '\'' +
                ", creator=" + creator +
                '}';
    }
}
