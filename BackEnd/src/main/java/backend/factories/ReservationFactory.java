package backend.factories;

import backend.domain.Reservation;

import java.util.Map;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
public class ReservationFactory {
    public static Reservation createReservation(Map<String, String> values)
    {
        Reservation reservation = new Reservation.Builder()
                .date(values.get("date"))
                .duration("duration")
                .build();
        return reservation;
    }
}
