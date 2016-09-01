package backend.factories;

import backend.domain.System;

import java.util.Map;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
public class SystemFactory {
    public static System createSystem(Map<String, String> values)
    {
        System system = new System.Builder()
                .userDetails(values.get("userDetails"))
                .reservationDetails("reservationDetails")
                .build();
        return system;
    }
}
