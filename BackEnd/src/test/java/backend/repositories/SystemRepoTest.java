package backend.repositories;

import backend.App;
import backend.domain.System;
import backend.factories.SystemFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by NXA-C.unltd on 2016/09/01.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SystemRepoTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private SystemRepository systemRepository;

    @Test
    public void testCreate() throws Exception {
        HashMap<String, String> values = new HashMap<>();
        values.put("userDetails", "Bruce, Wayne, 15/03/1970, bruce@wayne.com, 555-201-336");
        values.put("reservationDetails", "10 September 2016, 7");
        System system = SystemFactory.createSystem(values);
        systemRepository.save(system);
        id = system.getId();
        Assert.assertNotNull(system.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        System system = systemRepository.findOne(id);
        Assert.assertEquals("Bruce, Wayne, 15/03/1970, bruce@wayne.com, 555-201-336", system.getUserDetails());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        System system = systemRepository.findOne(id);
        System newSystem = new System.Builder()
                .copy(system)
                .reservationDetails("31 August 2016, 3")
                .build();
        systemRepository.save(newSystem);
        Assert.assertEquals("31 August 2016, 3", newSystem.getReservationDetails());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        System system = systemRepository.findOne(id);
        systemRepository.delete(system);
        System deletedSystem = systemRepository.findOne(id);
        Assert.assertNull(deletedSystem);
    }
}
