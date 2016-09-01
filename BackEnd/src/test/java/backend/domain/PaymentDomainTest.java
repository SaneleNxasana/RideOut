package backend.domain;

import backend.factories.PaymentFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by NXA-C.unltd on 2016/08/29.
 */
public class PaymentDomainTest extends TestCase{

    public PaymentDomainTest(){}

    @Test
    public void testCreate() throws Exception {
        HashMap<String, String> values = new HashMap<>();
        values.put("paymentType", "Cash");
        values.put("amount", "7500.00");
        Payment payment = PaymentFactory.createPayment(values);
        Assert.assertEquals("Cash", payment.getPaymentType());
    }

    @Test
    public void testUpdate() throws Exception {
        HashMap values = new HashMap<>();
        values.put("paymentType", "Cash");
        values.put("amount", "7500.00");
        Payment payment = PaymentFactory.createPayment(values);
        Payment newPayment = (new Payment.Builder()
                .copy(payment).paymentType("Cheque")
                .amount("7500.00").build());
        Assert.assertEquals("Cheque", newPayment.getPaymentType());
    }
}
