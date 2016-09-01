package backend.api;

import backend.domain.System;
import backend.services.SystemService;
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
public class SystemController {

    //Inject Service
    @Autowired
    private SystemService systemService;

    //--------------Create System----------------//

    @RequestMapping(value = "/system/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSystem(@RequestBody System system, UriComponentsBuilder ucBuilder){
        systemService.create(system);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/system/{id}").buildAndExpand(system.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------Retrieve Single System Record------------//

    @RequestMapping(value = "/system{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<System> getSystem(@PathVariable("id") long id){
        System system = systemService.readById(id);
        if (system == null) {
            return new ResponseEntity<System>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<System>(system, HttpStatus.OK);
    }

    //---------------Retrieve All System Records-------------------//

    @RequestMapping(value = "/system/", method = RequestMethod.GET)
    public ResponseEntity<Set<System>> getSystems() {
        Set<System> systems = systemService.readAll();
        if (systems.isEmpty()){
            return new ResponseEntity<Set<System>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Set<System>>(systems, HttpStatus.OK);
    }

    //--------------Update A System Record-----------------------//

    @RequestMapping(value = "/system/{id}", method = RequestMethod.GET)
    public ResponseEntity<System> updateSystem(@PathVariable("id") long id, @RequestBody System system){
        System currentSystem = systemService.readById(id);

        if (currentSystem == null) {
            return new ResponseEntity<System>(HttpStatus.NOT_FOUND);
        }
        System updatedSystem = new System.Builder()
                .copy(currentSystem)
                .id(system.getId())
                .userDetails(system.getUserDetails())
                .reservationDetails(system.getReservationDetails())
                .build();
        systemService.update(updatedSystem);
        return new ResponseEntity<System>(updatedSystem, HttpStatus.OK);
    }

    //---------------Delete A System Record--------------//

    @RequestMapping(value = "/system/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<System> deleteSystem(@PathVariable("id") long id){
        System system = systemService.readById(id);
        if (system == null) {
            return new ResponseEntity<System>(HttpStatus.NOT_FOUND);
        }
        systemService.delete(system);
        return new ResponseEntity<System>(HttpStatus.NO_CONTENT);
    }
}
