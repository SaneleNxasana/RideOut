package backend.services;

import backend.App;
import backend.domain.Payment;
import backend.factories.PaymentFactory;
import backend.repositories.PaymentRepository;
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
public class PaymentServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private PaymentService service;
    
    @Autowired
    private PaymentRepository repository;

    @Test
    public void testCreate() throws Exception {
        HashMap<String, String> values = new HashMap<>();
        values.put("paymentType", "Cheque");
        values.put("amount", "5250.00");
        Payment payment = PaymentFactory.createPayment(values);
        repository.save(payment);
        id = payment.getId();
        Assert.assertNotNull(payment);
    }

/*    @Test(dependsOnMethods = "testCreate")
    public void testUpdate() throws Exception {
        Payment payment = repository.findOne(id);
        Payment newPayment = new Payment.Builder()
                .copy(payment)
                .paymentType("Credit Card")
                .build();
        repository.save(newPayment);
        Assert.assertEquals("Credit Card", newPayment);
    }

/*    @Test(dependsOnMethods = "testCreate")
    public void testUpdate() throws Exception {
        Payment payment = new Payment.Builder()
                .id(123456)
                .paymentType("Credit Card")
                .amount("7500.00")
                .build();

        Payment xPayment = repository.findOne(90059L);
        Payment newPayment = new Payment.Builder()
                .copy(xPayment)
                .paymentType("Cash")
                .amount("3500.00")
                .build();

        service.update(newPayment);
        Payment pymnt = repository.findOne(90059L);
        Assert.assertEquals(pymnt.getAmount(), "3500.00");
    }*/

    @Test(dependsOnMethods="testCreate")
    public void testDelete() throws Exception {
        Payment payment = repository.findOne(id);
        repository.delete(payment);
        Payment deletedPayment = repository.findOne(id);
        Assert.assertNull(deletedPayment);
    }
}
