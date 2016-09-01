package backend.factories;

import backend.domain.Payment;

import java.util.Map;

/**
 * Created by NXA-C.unltd on 2016/08/29.
 */
public class PaymentFactory {
    public static Payment createPayment(Map<String, String> values)
    {
        Payment payment = new Payment.Builder()
                .paymentType(values.get("paymentType"))
                .amount("amount")
                .build();
        return payment;
    }
}
