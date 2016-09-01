package backend.repositories;

import backend.App;
import backend.domain.Payment;
import backend.factories.PaymentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by NXA-C.unltd on 2016/08/29.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class PaymentRepoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PaymentRepository paymentRepository;

    private Long id;

    @Test
    public void testCreate() throws Exception {
            HashMap<String, String> values = new HashMap<>();
            values.put("paymentType", "Cash");
            values.put("amount", "7500.00");
            Payment payment = PaymentFactory.createPayment(values);
        paymentRepository.save(payment);
        id = payment.getId();
        Assert.assertNotNull(payment.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Payment payment = paymentRepository.findOne(id);
        Assert.assertEquals("Cash", payment.getPaymentType());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Payment payment = paymentRepository.findOne(id);
        Payment newPayment = new Payment.Builder()
                .copy(payment)
                .paymentType("Credit Card")
                .build();
        paymentRepository.save(newPayment);
        Assert.assertEquals("Credit Card", newPayment.getPaymentType());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Payment payment = paymentRepository.findOne(id);
        paymentRepository.delete(payment);
        Payment deletedPayment = paymentRepository.findOne(id);
        Assert.assertNull(deletedPayment);
    }
}
