package io.PersonAdapter;

import java.io.DataOutput;
import java.io.IOException;


public class EntityDataOutput implements EntityOutput {

    private final DataOutput out;

    public EntityDataOutput(DataOutput out) {
        this.out = out;
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.writeUTF(person.getName());
        out.writeInt(person.getAge());
        out.writeInt(person.getSex().length);
        for (Person.Sex sex: person.getSex()){
            out.writeBoolean(sex == Person.Sex.F);
        }
    }
}
