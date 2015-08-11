package io.PersonAdapter;

import java.util.Arrays;

public class Person {

    public enum Sex {
        F, M
    }
    private String name;
    private int age;
    private Sex[] sex;

    public Person(String name, int age, Sex[] sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public Sex[] getSex() {
        return sex;
    }

    public void setSex(Sex[] sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + Arrays.toString(sex) +
                '}';
    }
}


