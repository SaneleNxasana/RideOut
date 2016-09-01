package backend.domain;

import backend.factories.SystemFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by NXA-C.unltd on 2016/09/01.
 */
public class SystemDomainTest extends TestCase {

    public SystemDomainTest() {
    }

    @Test
    public void testCreate() throws Exception {
        HashMap<String, String> values = new HashMap<>();
        values.put("userDetails", "Bruce, Wayne, 15/03/1970, bruce@wayne.com, 555-201-336");
        values.put("reservationDetails", "10 September 2016, 7");
        System system = SystemFactory.createSystem(values);
        Assert.assertEquals("Bruce, Wayne, 15/03/1970, bruce@wayne.com, 555-201-336", system.getUserDetails());
    }

    @Test
    public void testUpdate() throws Exception {
        HashMap values = new HashMap<>();
        values.put("userDetails", "Bruce, Wayne, 15/03/1970, bruce@wayne.com, 555-201-336");
        values.put("reservationDetails", "10 September 2016, 7");
        System system = SystemFactory.createSystem(values);
        System newSystem = (new System.Builder()
                .copy(system).userDetails("Bruce, Wayne, 15/03/1970, bruce@wayne.com, 679-231-536"))
                .reservationDetails("10 September 2016, 7").build();
        Assert.assertEquals("Bruce, Wayne, 15/03/1970, bruce@wayne.com, 679-231-536", newSystem.getUserDetails());
    }
}
