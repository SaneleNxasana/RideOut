package backend.api;

import backend.domain.Payment;
import backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/26.
 */
@RestController
public class PaymentController {

    //Inject Service
    @Autowired
    private PaymentService paymentService;

    //--------------Create Payment----------------//

    @RequestMapping(value = "/payment/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPayment(@RequestBody Payment payment, UriComponentsBuilder ucBuilder){
        paymentService.create(payment);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/payment/{id}").buildAndExpand(payment.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------Retrieve Single Payment------------//

    @RequestMapping(value = "/payment{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> getPayment(@PathVariable("id") long id){
        Payment payment = paymentService.readById(id);
        if (payment == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Payment>(payment, HttpStatus.OK);
    }

    //---------------Retrieve All Payments-------------------//

    @RequestMapping(value = "/payment/", method = RequestMethod.GET)
    public ResponseEntity<Set<Payment>> getPayments() {
        Set<Payment> payments = paymentService.readAll();
        if (payments.isEmpty()){
            return new ResponseEntity<Set<Payment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Set<Payment>>(payments, HttpStatus.OK);
    }

    //--------------Update A Payment-----------------------//

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Payment> updatePayment(@PathVariable("id") long id, @RequestBody Payment payment){
        Payment currentPayment = paymentService.readById(id);

        if (currentPayment == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
        Payment updatedPayment = new Payment.Builder().copy(currentPayment)
                .id(payment.getId())
                .paymentType(payment.getPaymentType())
                .amount(payment.getAmount())
                .build();
        paymentService.update(updatedPayment);
        return new ResponseEntity<Payment>(updatedPayment, HttpStatus.OK);
    }

    //---------------Delete A Payment--------------//

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Payment> deletePayment(@PathVariable("id") long id){
        Payment payment = paymentService.readById(id);
        if (payment == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
        paymentService.delete(payment);
        return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);
    }
}
