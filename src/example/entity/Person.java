package example.entity;

public class Person {

    private String name;
    private String address;
    private String phone;

    public Person(String name, String address, String phone){

        setName(name);
        setAddress(address);
        setPhone(phone);
    }

    public String getName(){

        return name;
    };

    public String getAddress() {

        return address;
    }

    public String getPhone() {

        return phone;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }
}
