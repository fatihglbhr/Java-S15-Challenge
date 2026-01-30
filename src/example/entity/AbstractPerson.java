package example.entity;

public abstract class AbstractPerson {

    private long id;
    private String name;
    private String address;
    private String phone;

    public String getName(){

        return name;
    };

    public String getAddress() {

        return address;
    }

    public String getPhone() {

        return phone;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public abstract Book showBook(Long key);


}
