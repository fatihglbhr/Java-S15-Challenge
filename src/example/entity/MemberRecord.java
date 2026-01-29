package example.entity;

import example.entity.enums.MemberTypesEnum;

import java.util.Date;
import java.util.Objects;

public class MemberRecord extends Reader {

    private long id;
    private MemberTypesEnum type;
    private Date dateOfMembership;

    private int bookCount;
    private double paymentNeeded;


    public MemberRecord(long id,
                        String name,
                        MemberTypesEnum type,
                        String address,
                        String phone) {

        super(name,address,phone);
        setId(id);
        setType(type);
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

    public void setType(MemberTypesEnum type) {
        this.type = type;
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

        MemberRecord memberRecord = (MemberRecord) obj;
        return memberRecord.id == id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
