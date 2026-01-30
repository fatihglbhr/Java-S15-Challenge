package example.entity;

import java.util.Date;
import java.util.Objects;

public class LibraryMembers extends AbstractPerson {

    private long id;
    private Date dateOfMembership;
    private int bookCount;
    private double paymentNeeded;


    public LibraryMembers(long id,
                          String name,
                          String address,
                          String phone) {

        setName(name);
        setAddress(address);
        setPhone(phone);
        setId(id);
        setDateOfMembership(new Date());
        bookCount = 0;

        SingletonLibrary.getInstance().getReaders().put(id,this);
    }

    public void increment(){
        bookCount++;
    }

    public void decrement(){
        bookCount--;
    }

    public void setPaymentNeeded(double paymentNeeded) {
        this.paymentNeeded = paymentNeeded;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBookCount() {
        return bookCount;
    }

    public long getId() {

        return id;
    }

    public double getPaymentNeeded() {
        return paymentNeeded;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != getClass())
            return false;

        LibraryMembers libraryMembers = (LibraryMembers) obj;
        return libraryMembers.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


}
