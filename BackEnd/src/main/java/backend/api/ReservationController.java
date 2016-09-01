package backend.api;

import backend.domain.Reservation;
import backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@RestController
public class ReservationController {

    //Inject Service
    @Autowired
    private ReservationService reservationService;

    //--------------------Create Reservation-------------------//
    @RequestMapping(value = "/reservation/", method = RequestMethod.POST)
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder){
        reservationService.create(reservation);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/reservation/{id}").buildAndExpand(reservation.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------Retrieve Single Reservation------------//

    @RequestMapping(value = "/reservation{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") long id){
        Reservation reservation = reservationService.readById(id);
        if (reservation == null) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

    //---------------Retrieve All Reservations-------------------//

    @RequestMapping(value = "/reservation/", method = RequestMethod.GET)
    public ResponseEntity<Set<Reservation>> getResevations() {
        Set<Reservation> reservations = reservationService.readAll();
        if (reservations.isEmpty()){
            return new ResponseEntity<Set<Reservation>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Set<Reservation>>(reservations, HttpStatus.OK);
    }

    //--------------Update A Resrvation-----------------------//

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation){
        Reservation currentReservation = reservationService.readById(id);

        if (currentReservation == null) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
        Reservation updatedReservation = new Reservation.Builder()
                .copy(currentReservation)
                .id(reservation.getId())
                .date(reservation.getDate())
                .duration((reservation.getDuration()))
                .build();
        reservationService.update(updatedReservation);
        return new ResponseEntity<Reservation>(updatedReservation, HttpStatus.OK);
    }

    //---------------Delete A Reservation--------------//

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") long id){
        Reservation reservation = reservationService.readById(id);
        if (reservation == null) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
        reservationService.delete(reservation);
        return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
    }
}
