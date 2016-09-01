package backend.domain;

import backend.factories.ReservationFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by NXA-C.unltd on 2016/09/01.
 */
public class ReservationDomainTest extends TestCase {

    public ReservationDomainTest(){}

    @Test
    public void testCreate() throws Exception {
        HashMap<String, String> values = new HashMap<>();
        values.put("date", "23 August 2016");
        values.put("duration", "3");
        Reservation reservation = ReservationFactory.createReservation(values);
        Assert.assertEquals("23 August 2016", reservation.getDate());
    }

    @Test
    public void testUpdate() throws Exception {
        HashMap values = new HashMap<>();
        values.put("date", "23 August 2016");
        values.put("duration", "3");
        Reservation reservation = ReservationFactory.createReservation(values);
        Reservation newReservation = (new Reservation.Builder()
                .copy(reservation).date("27 August 2016")
                .duration("3").build());
        Assert.assertEquals("27 August 2016", newReservation.getDate());
    }
}
