package example.entity;

import java.util.Objects;

public class Student extends LibraryMembers {

    public Student(long id,
                   String name,
                   String address,
                   String phone) {

        super(id, name, address, phone);
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(obj == null || obj.getClass() != getClass()) return false;

        Student student = (Student)obj;

        return student.getId() == getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
