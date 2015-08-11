package io.PersonAdapter;

import java.io.*;


public class PersonDemo {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        new EntityDataOutput(new DataOutputStream(buff)).writePerson(
                new Person("Mike", 45,
                        new Person.Sex[]{Person.Sex.M}));
        byte[] bytes = buff.toByteArray();

        System.out.println(bytes.length);
        System.out.println(new String(bytes));

        Person p = new EntityDataInput(new DataInputStream(new ByteArrayInputStream(bytes))).readPerson();
        System.out.println(p);
    }
}
