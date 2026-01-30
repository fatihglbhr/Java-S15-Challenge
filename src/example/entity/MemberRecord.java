package example.entity;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class MemberRecord extends AbstractPerson {

    private long id;
    private Date dateOfMembership;
    private final Map<Long, Book> bookList;
    private int bookCount;
    private double paymentNeeded;


    public MemberRecord(long id,
                        String name,
                        String address,
                        String phone) {

        setName(name);
        setAddress(address);
        setPhone(phone);
        setId(id);
        setDateOfMembership(new Date());
        bookCount = 0;

        bookList = SingletonLibrary.getInstance().getBooks();
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

    @Override
    public Book showBook(Long key) {
        return bookList.get(key);
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

        MemberRecord memberRecord = (MemberRecord) obj;
        return memberRecord.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


}
