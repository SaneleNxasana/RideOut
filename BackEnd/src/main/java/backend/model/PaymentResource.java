package backend.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by NXA-C.unltd on 2016/08/29.
 */
public class PaymentResource extends ResourceSupport {

    private Long idNumber;
    private String paymentType;
    private String amount;

    public PaymentResource(){}

    public Long getIdNumber() {
        return idNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getAmount() {
        return amount;
    }

    public PaymentResource(PaymentResource.Builder builder){
        this.idNumber = builder.idNumber;
        this.paymentType = builder.paymentType;
        this.amount = builder.amount;
    }

    public static class Builder
    {
        private Long idNumber;
        private String paymentType;
        private String amount;

        public PaymentResource.Builder idNumber(Long value){
            this.idNumber = value;
            return this;
        }
        public PaymentResource.Builder paymentType(String value){
            this.paymentType = value;
            return this;
        }
        public PaymentResource.Builder amount(String value){
            this.amount = value;
            return this;
        }
        public PaymentResource.Builder copy(PaymentResource value){
            this.idNumber = value.idNumber;
            this.paymentType = value.paymentType;
            this.amount = value.amount;

            return this;
        }

        public PaymentResource build(){
            return new PaymentResource(this);
        }
    }
}
