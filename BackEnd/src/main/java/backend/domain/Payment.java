package backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by NXA-C.unltd on 2016/08/18.
 */
@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String paymentType;
    private String amount;

    public Payment(){    }

    public Payment(Builder builder){
        this.id = builder.id;
        this.paymentType = builder.paymentType;
        this.amount = builder.amount;
    }

    public long getId() {
        return id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getAmount() {
        return amount;
    }

    public static class Builder{
        private long id;
        private String paymentType;
        private String amount;

        public Builder id(long value){
            this.id = value;
            return this;
        }
        public Builder paymentType(String value){
            this.paymentType = value;
            return this;
        }
        public Builder amount(String value){
            this.amount = value;
            return this;
        }
        public Builder copy(Payment value){
            this.id = value.id;
            this.paymentType = value.paymentType;
            this.amount = value.amount;
            return this;
        }
        public Payment build(){
            return new Payment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return id == payment.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
