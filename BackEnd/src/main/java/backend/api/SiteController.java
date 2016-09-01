package backend.api;

import backend.domain.Site;
import backend.services.SiteService;
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
public class SiteController {

    //Inject Service
    @Autowired
    private SiteService siteService;

    //--------------Create Site----------------//

    @RequestMapping(value = "/site/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSite(@RequestBody Site site, UriComponentsBuilder ucBuilder){
        siteService.create(site);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/site/{id}").buildAndExpand(site.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------Retrieve Single Site Record------------//

    @RequestMapping(value = "/site{id}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Site> getSite(@PathVariable("id") long id){
        Site site = siteService.readById(id);
        if (site == null) {
            return new ResponseEntity<Site>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Site>(site, HttpStatus.OK);
    }

    //---------------Retrieve All Site Records-------------------//

    @RequestMapping(value = "/site/", method = RequestMethod.GET)
    public ResponseEntity<Set<Site>> getSites() {
        Set<Site> sites = siteService.readAll();
        if (sites.isEmpty()){
            return new ResponseEntity<Set<Site>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Set<Site>>(sites, HttpStatus.OK);
    }

    //--------------Update A Site Record-----------------------//

    @RequestMapping(value = "/site/{id}", method = RequestMethod.GET)
    public ResponseEntity<Site> updateSite(@PathVariable("id") long id, @RequestBody Site site){
        Site currentSite = siteService.readById(id);

        if (currentSite == null) {
            return new ResponseEntity<Site>(HttpStatus.NOT_FOUND);
        }
        Site updatedSite = new Site.Builder()
                .copy(currentSite)
                .id(site.getId())
                .name(site.getName())
                .url(site.getUrl())
                .reservationUrl(site.getReservationUrl())
                .build();
        siteService.update(updatedSite);
        return new ResponseEntity<Site>(updatedSite, HttpStatus.OK);
    }

    //---------------Delete A Site Record--------------//

    @RequestMapping(value = "/site/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Site> deleteSite(@PathVariable("id") long id){
        Site site = siteService.readById(id);
        if (site == null) {
            return new ResponseEntity<Site>(HttpStatus.NOT_FOUND);
        }
        siteService.delete(site);
        return new ResponseEntity<Site>(HttpStatus.NO_CONTENT);
    }
}
