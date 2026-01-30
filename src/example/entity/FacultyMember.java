package example.entity;

import java.util.Objects;

public class FacultyMember extends LibraryMembers {

    public FacultyMember(long id,
                         String name,
                         String address,
                         String phone) {

        super(id, name, address, phone);

    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != getClass()) return false;

        FacultyMember facultyMember = (FacultyMember) obj;
        return facultyMember.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
