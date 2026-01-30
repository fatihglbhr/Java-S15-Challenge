package example.entity;

import java.util.*;

public class Author extends AbstractPerson {

    public Author(long id, String name,  String address, String phone) {

        setId(id);
        setName(name);
        setAddress(address);
        setPhone(phone);

        SingletonLibrary.getInstance().getAuthorsList().put(id,this);
    }

    @Override
    public boolean equals(Object obj) {


        if(obj == this)
            return true;
        if(obj == null || obj.getClass()!=getClass())
            return false;

        Author author = (Author) obj;
        return author.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString(){

        return getName();
    }
}
